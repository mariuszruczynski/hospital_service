package hospital_service.hospital_service.controller;

import hospital_service.hospital_service.model.*;
import hospital_service.hospital_service.services.DoctorEntityService;
import hospital_service.hospital_service.services.HospitalDoctorsEntityService;
import hospital_service.hospital_service.services.HospitalEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class HospitalController {

    private final HospitalEntityService hospitalEntityService;
    private final HospitalDoctorsEntityService hospitalDoctorsEntityService;

    public HospitalController(HospitalEntityService hospitalEntityService, HospitalDoctorsEntityService hospitalDoctorsEntityService) {
        this.hospitalEntityService = hospitalEntityService;
        this.hospitalDoctorsEntityService = hospitalDoctorsEntityService;
    }

    @RequestMapping(value = {"/hospitalList"}, method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("hospitals", hospitalEntityService.findAll());
        return "hospitalList";
    }

    @RequestMapping(value = {"/addHospital"}, method = RequestMethod.GET)
    public String addHospital(Model model) {
        model.addAttribute("hospitalForm", new HospitalForm());
        return "addHospital";
    }

    @PostMapping(path = "/addHospital")
    public String createHospital(@ModelAttribute("doctorForm") HospitalForm hospitalForm, Model model) {
       List<HospitalEntity> list = hospitalEntityService.findAll();

        for(HospitalEntity hosp:list){
            if (hospitalForm.getName().equalsIgnoreCase(hosp.getName())){
                return "redirect:/errorHospitalPage";
            }
        }
        hospitalEntityService.create(hospitalForm);
        return "redirect:/hospitalList";
    }

    @GetMapping(path = "/{id}/deleteHospital")
    public String deleteHospital(@PathVariable Long id) {

        hospitalEntityService.deleteById(id);
        return "redirect:/hospitalList";
    }

    @GetMapping(path = "/{id}/editHospital")
    public String editDoctor(@PathVariable Long id, Model model) {

        EditHospital editHospital = new EditHospital();
        HospitalDTO hospital = hospitalEntityService.findById(id);
        model.addAttribute("currentHospital", hospital);
        model.addAttribute("editHospital", editHospital);
        return "editHospital";

    }

    @PostMapping(path = "/editHospital")
    public String editHospital(@ModelAttribute EditHospital editHospital) {
        hospitalEntityService.editHospital(editHospital);
        return "redirect:hospitalList";
    }

    @RequestMapping(value = {"/{id}/hospitalDetails"}, method = RequestMethod.GET)
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("hospital", hospitalEntityService.findById(id));
        model.addAttribute("doctors", hospitalDoctorsEntityService.findDoctorIdByHospitalId(id));
        return "hospitalDetails";
    }
}
