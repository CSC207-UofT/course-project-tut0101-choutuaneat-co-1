package ChouTuanEat.Co.controller;

import ChouTuanEat.Co.entity.User;
import ChouTuanEat.Co.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("registerPage")
public class RegisterController {
    private static User DUMMY_FORM_PLACEHOLDER_STUDENT = new User();

    @Autowired
    private UserService userService;

    @GetMapping("registerPage")
    public String getRegisterPage(Model model) {
        model.addAttribute("user", DUMMY_FORM_PLACEHOLDER_STUDENT);

        return "registerPage";
    }

    @PostMapping("registerPage")
    public String register(@ModelAttribute(value="user") User user, Model model){

        User client = userService.getUserByUsername(user.getId());

        if(client == null){

            if(userService.checkName(user.getUsername())){

                if(userService.checkPassword(user.getPassword())){

                    userService.saveOrUpdate(user);

                    model.addAttribute("user", user);
                    model.addAttribute("message", "Register success!");

                    return "login";

                }else{
                    model.addAttribute("user", user);
                    model.addAttribute("message", "Invalid Username!\n " +
                            "Username cannot contain any special characters!");

                    return "registerPage";
                }

            }else{
                model.addAttribute("user", user);
                model.addAttribute("message", "Invalid Password!\n " +
                        "Password must contain at least one Uppercase and Lowercase letter!");

                return "registerPage";
            }
        }

        model.addAttribute("user", user);
        model.addAttribute("message", "User already exists!");

        return "registerPage";
    }

}
