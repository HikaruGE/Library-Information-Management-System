package my.library.demo.controller;

import my.library.demo.model.User;
import my.library.demo.service.IUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserInfoController {

    @Autowired
    IUserManageService userManageService;

    @RequestMapping("/userInfo")
    public String userInfo(Model model){
        UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userManageService.searchUserByName(user.getUsername()));
        return "userInfo";
    }

    @RequestMapping("/userInfo/edit")
    public String userInfoEdit(Model model){
        UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userManageService.searchUserByName(user.getUsername()));
        return "userInfoEdit";
    }

    @PutMapping("/userInfo/{id}")
    public String userInfoSave(User user, @PathVariable Long id){
        userManageService.editUserInfo(user,id);
        return "redirect:/userInfo";
    }
}
