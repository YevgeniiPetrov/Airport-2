package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.TicketController;
import com.petrov.airport.dto.RequestTicketDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseTicketDTO;
import com.petrov.airport.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
