package hospital_service.hospital_service.controller;

import hospital_service.hospital_service.model.UserDto;
import hospital_service.hospital_service.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("addUser")
    public String addUserForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "addUser";
    }

    @RequestMapping(path = "addUser", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute UserDto userDto,
                             Model model) {
        userService.createUser(userDto);
        return "redirect:/";
    }


}
