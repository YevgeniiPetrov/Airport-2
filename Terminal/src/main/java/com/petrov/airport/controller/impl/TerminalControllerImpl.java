package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.TerminalController;
import com.petrov.airport.dto.RequestTerminalDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.service.TerminalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TerminalControllerImpl implements TerminalController {
    private TerminalService terminalService;

    @Override
    @GetMapping("/terminal/flights/get")
    public List<Integer> getAllFlightIds(int id) {
        return terminalService.getAllFlightIds(id);
    }

    @Override
    @PostMapping("/terminal/add")
    public ResponseCompleted add(@RequestBody RequestTerminalDTO requestTerminalDTO) {
        return terminalService.add(requestTerminalDTO);
    }
}
