package hospital_service.hospital_service.controller;

import hospital_service.hospital_service.model.DoctorDTO;
import hospital_service.hospital_service.model.DoctorForm;
import hospital_service.hospital_service.model.HospitalDoctorsForm;
import hospital_service.hospital_service.services.DoctorEntityService;
import hospital_service.hospital_service.services.HospitalDoctorsEntityService;
import hospital_service.hospital_service.services.HospitalEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class HospitalDoctorsController {

    private final HospitalDoctorsEntityService hospitalDoctorsEntityService;
    private final HospitalEntityService hospitalEntityService;
    private final DoctorEntityService doctorEntityService;

    public HospitalDoctorsController(HospitalDoctorsEntityService hospitalDoctorsEntityService, HospitalEntityService hospitalEntityService, DoctorEntityService doctorEntityService) {
        this.hospitalDoctorsEntityService = hospitalDoctorsEntityService;
        this.hospitalEntityService = hospitalEntityService;
        this.doctorEntityService = doctorEntityService;
    }

    @RequestMapping(value = {"/hireDoctor"}, method = RequestMethod.GET)
    public String hireDoctor(Model model) {
        model.addAttribute("hireForm", new HospitalDoctorsForm());
        model.addAttribute("hospitalList", hospitalEntityService.findAll());
        model.addAttribute("doctorList", doctorEntityService.findAll());
        return "hireDoctor";

    }

    @PostMapping(path = "/hireDoctor")
    public String hireDoctor(@ModelAttribute("hireForm") HospitalDoctorsForm hospitalDoctorsForm, Model model) {
        if (hospitalDoctorsForm.getContractStartDate().after(hospitalDoctorsForm.getContractEndDate())) {
            return "redirect:/errorPage";
        }
        hospitalDoctorsEntityService.create(hospitalDoctorsForm);
        return "redirect:/index";
    }


}
