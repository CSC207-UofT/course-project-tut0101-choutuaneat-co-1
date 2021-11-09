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

        User client = userService.getUserByUsername(user.getId());

        if (client != null && client.getPassword().equals(user.getPassword())) {
            model.addAttribute("user", user);
            model.addAttribute("message", "Welcome");

            return "userInfoPage";
        }

        model.addAttribute("user", DUMMY_FORM_PLACEHOLDER_STUDENT);
        model.addAttribute("message", "Invalid Login!");

        return "login";
    }
}
