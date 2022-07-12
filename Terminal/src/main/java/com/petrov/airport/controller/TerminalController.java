package com.petrov.airport.controller;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TerminalController {
    List<Integer> getAllFlightIds(@RequestParam int id);
}
