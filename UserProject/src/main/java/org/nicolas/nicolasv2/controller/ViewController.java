package org.nicolas.nicolasv2.controller;

import org.nicolas.nicolasv2.entity.User;
import org.nicolas.nicolasv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    @Autowired
    private UserService UserService;

/*    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }*/


    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("users", UserService.getUsers());
        model.addAttribute("newUsers", new User());
        return "view";
    }

    @GetMapping("/view/{id}")
    public String viewById(@PathVariable int id, Model model) {
        model.addAttribute("user", UserService.getUser(id));
        return "view-id";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        //model.addAttribute("user", UserService.getUser(id));
        return "signup_form";
    }

    @GetMapping("/login")
    public String viewLogin(Model model) {
        //model.addAttribute("user", UserService.getUser(id));
        return "login";
    }

    @GetMapping("/home")
    public String viewHome(Model model) {
        //model.addAttribute("user", UserService.getUser(id));
        return "home";
    }

/*    @PostMapping("/process_register")
    public String processRegister(User user) {
        String password = user.getPassword();
        user.setPassword(password);

        UserService.save(user);

        return "register_success";
    }*/

/*    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("users", UserService.getUsers());
        model.addAttribute("newUsers", new User());
        return "view";
    }*/

}