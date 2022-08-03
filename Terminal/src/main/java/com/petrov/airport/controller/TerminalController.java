package com.petrov.airport.controller;

import com.petrov.airport.dto.RequestTerminalDTO;
import com.petrov.airport.dto.ResponseCompleted;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TerminalController {
    List<Integer> getAllFlightIds(@RequestParam int id);
    ResponseCompleted add(@RequestBody RequestTerminalDTO requestTerminalDTO);
}
