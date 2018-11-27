package hospital_service.hospital_service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/hospitalList")
public class HospitalController {

    private final HospitalEntityService hospitalEntityService;

    public HospitalController(HospitalEntityService hospitalEntityService) {
        this.hospitalEntityService = hospitalEntityService;
    }

    @GetMapping(path = {"/", "/all"})
    public String findAll(Model model) {
        model.addAttribute("hospitals", hospitalEntityService.findAll());
        return "hospitalList";
    }
}
