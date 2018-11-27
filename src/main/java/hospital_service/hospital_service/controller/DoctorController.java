package hospital_service.hospital_service.controller;

import hospital_service.hospital_service.model.DoctorForm;
import hospital_service.hospital_service.services.DoctorEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        doctorEntityService.create(doctorForm);
        return "redirect:/doctorList";
    }

    @GetMapping(path ="/{id}/deleteDoctor")
    public String deleteDoctor(@PathVariable Long id) {

            doctorEntityService.deleteById(id);
            return "redirect:/doctorList";

    }

}
