package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

import com.scm.helper.RegisterForm;
import com.scm.services.impl.UserImpl;

@Controller
public class MainController {

    @Autowired
    private UserImpl userImpl;

    @GetMapping("/")
    public String homepage() {
        return "home";
    }

    
    @GetMapping("/services")
    public String servicepage() {
        return "services";
    }

    
    @GetMapping("/contact")
    public String contactpage() {
        return "contact";
    }

    @GetMapping("/about")
    public String abputpage() {
        return "about";
    }
    
    @GetMapping("/login")
    public String loginpage() {
        return "login";
    }

    @PostMapping("/registeruser")
    public String registerUser(@ModelAttribute RegisterForm registerForm) {
        userImpl.saveUser(registerForm);
        return "redirect:/login";
    }

    
    @GetMapping("/signup")
    public String registerpage(Model model) {
        RegisterForm registerForm = new RegisterForm();
        model.addAttribute("registerform", registerForm);
        return "signup";
    }

}
