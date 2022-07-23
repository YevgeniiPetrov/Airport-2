package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.PlaneController;
import com.petrov.airport.dto.ResponsePlaneDTO;
import com.petrov.airport.dto.ResponsePlaneWithAirlineDTO;
import com.petrov.airport.service.PlaneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PlaneControllerImpl implements PlaneController {
    private PlaneService planeService;

    @Override
    @GetMapping("/plane/get")
    public ResponsePlaneDTO get(@RequestParam int id) {
        return planeService.get(id);
    }

    @Override
    @GetMapping("/plane/getWithAirline")
    public ResponsePlaneWithAirlineDTO getWithAirline(@RequestParam int id) {
        return planeService.getWithAirline(id);
    }
}
