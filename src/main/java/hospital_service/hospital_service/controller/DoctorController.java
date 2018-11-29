package hospital_service.hospital_service.controller;

import hospital_service.hospital_service.model.DoctorDTO;
import hospital_service.hospital_service.model.DoctorEntity;
import hospital_service.hospital_service.model.DoctorForm;
import hospital_service.hospital_service.model.EditDoctor;
import hospital_service.hospital_service.services.DoctorEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class DoctorController {

    private final DoctorEntityService doctorEntityService;
    public DoctorController(DoctorEntityService doctorEntityService) {
        this.doctorEntityService = doctorEntityService;
    }

    @RequestMapping(value = {"/doctorList"}, method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("doctors", doctorEntityService.findAll());
        return "doctorList";
    }

    @RequestMapping(value = {"/addDoctor"}, method = RequestMethod.GET)
    public String addDoctor(Model model) {
        model.addAttribute("doctorForm", new DoctorForm());
        return "addDoctor";
    }

    @PostMapping(path = "/addDoctor")
    public String createDoctor(@ModelAttribute("doctorForm") DoctorForm doctorForm, Model model) {
        List<DoctorEntity> list = doctorEntityService.findAll();

        for (DoctorEntity doc : list) {
            if (doctorForm.getLicenceNumber().equals(doc.getLicenceNumber())) {
                return "redirect:/errorLicenceNumberPage";
            }
        }
        doctorEntityService.create(doctorForm);
        return "redirect:/doctorList";
    }

    @GetMapping(path = "/{id}/deleteDoctor")
    public String deleteDoctor(@PathVariable Long id) {
        doctorEntityService.deleteById(id);
        return "redirect:/doctorList";
    }

    @GetMapping(path = "/{id}/editDoctor")
    public String editDoctor(@PathVariable Long id, Model model) {

        EditDoctor editDoctor = new EditDoctor();
        DoctorDTO doctor = doctorEntityService.findById(id);
        model.addAttribute("currentDoctor", doctor);
        model.addAttribute("editDoctor", editDoctor);
        return "editDoctor";

    }

    @PostMapping(path = "/editDoctor")
    public String editDoctor(@ModelAttribute EditDoctor editDoctor) {
        doctorEntityService.editDoctor(editDoctor);
        return "redirect:doctorList";
    }
}
