package hospital_service.hospital_service.controller;

import hospital_service.hospital_service.model.HospitalEntity;
import hospital_service.hospital_service.services.HospitalEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;




@Controller
public class HospitalController {

    private final HospitalEntityService hospitalEntityService;

    public HospitalController(HospitalEntityService hospitalEntityService) {
        this.hospitalEntityService = hospitalEntityService;
    }

    @RequestMapping(value = {"/hospitalList" }, method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("hospitals", hospitalEntityService.findAll());
        return "hospitalList";
    }

}
