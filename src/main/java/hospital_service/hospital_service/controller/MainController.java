package hospital_service.hospital_service.controller;

import hospital_service.hospital_service.services.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private final UserUtils userUtils;

    public MainController(UserUtils userUtils) {
        this.userUtils = userUtils;
    }


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
       model.addAttribute("loggedUser", userUtils.getLoggedUserName());
        return "index";
    }
}
