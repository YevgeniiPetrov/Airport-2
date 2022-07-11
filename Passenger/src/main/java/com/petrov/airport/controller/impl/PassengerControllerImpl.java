package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.PassengerController;
import com.petrov.airport.dto.RequestPassengerDTO;
import com.petrov.airport.dto.RequestPassengerTicketsDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponsePassengerDTO;
import com.petrov.airport.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class PassengerControllerImpl implements PassengerController {
    private PassengerService passengerService;

    @Override
    @GetMapping("/passenger/get")
    public ResponsePassengerDTO get(@RequestParam int id) {
        return passengerService.get(id);
    }

    @Override
    @PostMapping("/passenger/create")
    public ResponseCompleted create(@RequestBody @Valid RequestPassengerDTO requestPassengerDTO) {
        return passengerService.add(requestPassengerDTO);
    }

    @Override
    @PostMapping("/passenger/tickets/create")
    public ResponseCompleted createTickets(@RequestBody @Valid RequestPassengerTicketsDTO requestPassengerTicketsDTO) {
        return passengerService.addTickets(requestPassengerTicketsDTO);
    }
}
