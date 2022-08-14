package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.MainController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class MainControllerImpl implements MainController {
    @Override
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @Override
    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @Override
    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login-error";
    }
}
