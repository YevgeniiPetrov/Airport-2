package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.TerminalController;
import com.petrov.airport.service.TerminalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TerminalControllerImpl implements TerminalController {
    private TerminalService terminalService;

    @Override
    @GetMapping("/terminal/flights/get")
    public List<Integer> getAllFlightIds(int id) {
        return null;
    }
}
