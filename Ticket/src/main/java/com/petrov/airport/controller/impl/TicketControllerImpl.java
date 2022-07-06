package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.TicketController;
import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.RequestTicketDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseTicketDTO;
import com.petrov.airport.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    @GetMapping("/ticket/find/")
    public List<ResponseTicketDTO> getTicketsBetweenDates(
            @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
            @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo) {
        return ticketService.getTicketsBetweenDates(dateFrom, dateTo);
    }
}
