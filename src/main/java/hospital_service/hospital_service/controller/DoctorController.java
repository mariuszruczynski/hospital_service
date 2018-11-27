package hospital_service.hospital_service.controller;

import hospital_service.hospital_service.services.DoctorEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DoctorController {


    private final DoctorEntityService doctorEntityService;

    public DoctorController(DoctorEntityService doctorEntityService) {
        this.doctorEntityService = doctorEntityService;
    }


    @RequestMapping(value = {"/doctorList" }, method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("doctors", doctorEntityService.findAll());
        return "doctorList";
    }
}
