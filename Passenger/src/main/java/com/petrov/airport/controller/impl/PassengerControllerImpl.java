package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.PassengerController;
import com.petrov.airport.dto.ResponsePassengerDTO;
import com.petrov.airport.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PassengerControllerImpl implements PassengerController {
    private PassengerService passengerService;

    @Override
    @GetMapping("/passenger/get")
    public ResponsePassengerDTO get(@RequestParam int id) {
        return passengerService.get(id);
    }
}
