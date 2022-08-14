package com.petrov.airport.controller;

import org.springframework.ui.Model;

public interface MainController {
    String login();
    String success();
    String loginError(Model model);
}
