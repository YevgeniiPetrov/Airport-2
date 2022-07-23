package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.AirlineController;
import com.petrov.airport.dto.ResponseAirlineDTO;
import com.petrov.airport.service.AirlineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AirlineControllerImpl implements AirlineController {
    private AirlineService airlineService;

    @Override
    @GetMapping("/airline/get")
    public ResponseAirlineDTO get(@RequestParam int id) {
        return airlineService.getResponseAirlineDTO(id);
    }
}
