package my.library.demo.controller;

import my.library.demo.model.User;
import my.library.demo.service.IUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AuthenticationController {

    @Autowired
    IUserManageService userManageService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/registerPage")
    public String registerPage() {
        return "register";
    }

    @RequestMapping("/register")
    public String register(Model model, User user) {
        if(userManageService.registerNewUser(user)){
            return "redirect:/login";
        }else{
            model.addAttribute("msg","Username has already existed!");
            return "register";
        }
    }
}
