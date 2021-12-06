package ChouTuanEat.controller;

import ChouTuanEat.entity.User;
import ChouTuanEat.usecase.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("login")
public class LoginController {
    private static final User DUMMY_FORM_PLACEHOLDER_STUDENT = new User();

    @Autowired
    private UserService userService;

    @GetMapping()
    public String getLoginPage(Model model) {
        model.addAttribute("user", DUMMY_FORM_PLACEHOLDER_STUDENT);

        return "login";
    }

    @PostMapping()
    public String login(@ModelAttribute(value="user") User user, Model model, HttpServletRequest request) {
        User client = userService.getUserByUsername(user.getUsername());
        if (client != null && client.getPassword().equals(user.getPassword())) {
            request.getSession().setAttribute("userId", client.getId());
            model.addAttribute("user", user);
            model.addAttribute("message", "Welcome");
//            return "index";
            return "redirect:/homepage";
        }

        if(client == null){
            model.addAttribute("user", user);
            model.addAttribute("message", "User not registered");

            return "login";
        }

        model.addAttribute("user", DUMMY_FORM_PLACEHOLDER_STUDENT);
        model.addAttribute("message", "Invalid Login!");

        return "login";
    }
}

