package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.PassengerController;
import com.petrov.airport.dto.*;
import com.petrov.airport.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @Override
    @DeleteMapping("/passenger/delete")
    public ResponseCompleted delete(@RequestBody @Valid RequestEntityDTO requestEntityDTO) {
        return passengerService.delete(requestEntityDTO);
    }

    @Override
    @GetMapping("/passenger/get/terminal")
    public List<ResponsePassengerDTO> getAllByTerminal(@RequestParam int id) {
        return passengerService.getAllByTerminal(id);
    }
}
