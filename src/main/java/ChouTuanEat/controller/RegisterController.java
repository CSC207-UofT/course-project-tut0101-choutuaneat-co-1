package ChouTuanEat.controller;

import ChouTuanEat.entity.User;
import ChouTuanEat.usecase.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("register")
public class RegisterController {
    private static final User DUMMY_FORM_PLACEHOLDER_STUDENT = new User();

    @Autowired
    private UserService userService;

    @GetMapping()
    public String getRegisterPage(Model model) {
        model.addAttribute("user", DUMMY_FORM_PLACEHOLDER_STUDENT);

        return "register";
    }

    @PostMapping()
    public String register(@ModelAttribute(value="user") User user, Model model){

        User client = userService.getUserByUsername(user.getUsername());

        if(client == null){
            if(userService.checkName(user.getUsername())){

                if(userService.checkPassword(user.getPassword())){

                    userService.saveOrUpdate(user);

                    model.addAttribute("user", user);
                    model.addAttribute("message", "Register success!");

                    return "login";

                }else{
                    model.addAttribute("user", user);
                    model.addAttribute("message", "Invalid Password! " +
                            "Password must contain at least one Uppercase and Lowercase letter!");

                    return "register";
                }

            }else{
                model.addAttribute("user", user);
                model.addAttribute("message", "Invalid Username! " +
                        "Username cannot contain any special characters!");

                return "register";
            }
        }

        model.addAttribute("user", user);
        model.addAttribute("message", "User already exists!");

        return "register";
    }

}
