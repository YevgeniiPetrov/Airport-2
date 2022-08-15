package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.AuthController;
import com.petrov.airport.dto.RequestAuthenticationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthControllerImpl implements AuthController {
    @Override
    @PostMapping("/auth/login")
    public ResponseEntity<?> authenticate(RequestAuthenticationDTO request) {
        return null;
    }

    @Override
    @PostMapping("/auth/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler handler = new SecurityContextLogoutHandler();
        handler.logout(request, response, null);
    }
}
