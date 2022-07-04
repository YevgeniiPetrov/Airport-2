package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.TicketController;
import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.RequestTicketDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseTicketDTO;
import com.petrov.airport.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class TicketControllerImpl implements TicketController {
    private TicketService ticketService;

    @Override
    @GetMapping("/ticket/get/")
    public ResponseTicketDTO get(int id) {
        return ticketService.get(id);
    }

    @Override
    @PostMapping("/ticket/create")
    public ResponseCompleted create(@RequestBody @Valid RequestTicketDTO requestTicketDTO) {
        return ticketService.add(requestTicketDTO);
    }

    @Override
    @DeleteMapping("/ticket/delete")
    public ResponseCompleted delete(@RequestBody @Valid RequestEntityDTO requestEntityDTO) {
        return ticketService.delete(requestEntityDTO);
    }

    @Override
    @DeleteMapping("/tickets/delete/flight")
    public ResponseCompleted deleteAllByFlight(@RequestBody @Valid RequestEntityDTO requestEntityDTO) {
        return ticketService.deleteAllByFlight(requestEntityDTO);
    }
}
