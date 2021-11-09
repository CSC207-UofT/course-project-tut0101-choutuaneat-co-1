package ChouTuanEat.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
    private static User DUMMY_FORM_PLACEHOLDER_STUDENT = new User();

    @Autowired
    private UserService userService;

    @GetMapping()
    public String getLoginPage(Model model) {
        model.addAttribute("user", DUMMY_FORM_PLACEHOLDER_STUDENT);

        return "login";
    }

    @PostMapping()
    public String login(@ModelAttribute(value="user") User user, Model model) {

        User user = userService.getUserByUsername(user.getUsername());

        if (user != null && user.getPassword().equals(user.getPassword())) {
            model.addAttribute("user", user);
            model.addAttribute("message", "sss");

            return "userInfoPage";
        }

        model.addAttribute("user", DUMMY_FORM_PLACEHOLDER_STUDENT);
        model.addAttribute("message", "Username or password is wrong!");

        return "login";
    }
}
