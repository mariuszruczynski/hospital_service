package hospital_service.hospital_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

    @RequestMapping(value = {"/errorPage"}, method = RequestMethod.GET)
    public String errorPage(Model model) {
        return "errorPage";
    }

    @RequestMapping(value = {"/errorLicenceNumberPage"}, method = RequestMethod.GET)
    public String errorLicenceNumberPage(Model model) {
        return "errorLicenceNumberPage";
    }

    @RequestMapping(value = {"/errorHospitalPage"}, method = RequestMethod.GET)
    public String errorHospitalPage(Model model) {
        return "errorHospitalPage";
    }
}
