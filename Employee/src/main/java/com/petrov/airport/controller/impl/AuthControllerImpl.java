package com.petrov.airport.controller.impl;

import com.petrov.airport.configuration.security.JWTProvider;
import com.petrov.airport.controller.AuthController;
import com.petrov.airport.dto.RequestAuthenticationDTO;
import com.petrov.airport.entity.User;
import com.petrov.airport.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class AuthControllerImpl implements AuthController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private JWTProvider jwtProvider;

    @Override
    @PostMapping("/auth/login")
    public ResponseEntity<?> authenticate(@RequestBody RequestAuthenticationDTO request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            User user = userRepository.get(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
            String token = jwtProvider.createToken(request.getEmail(), user.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("email", request.getEmail());
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.FORBIDDEN);
        }
    }

    @Override
    @PostMapping("/auth/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler handler = new SecurityContextLogoutHandler();
        handler.logout(request, response, null);
    }
}
