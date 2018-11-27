package hospital_service.hospital_service.controller;

import hospital_service.hospital_service.model.HospitalForm;
import hospital_service.hospital_service.services.HospitalEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class HospitalController {

    private final HospitalEntityService hospitalEntityService;

    public HospitalController(HospitalEntityService hospitalEntityService) {
        this.hospitalEntityService = hospitalEntityService;
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
        hospitalEntityService.create(hospitalForm);
        return "redirect:/hospitalList";
    }

    @GetMapping(path ="/{id}/deleteHospital")
    public String deleteHospital(@PathVariable Long id) {

        hospitalEntityService.deleteById(id);
        return "redirect:/hospitalList";
    }
}
