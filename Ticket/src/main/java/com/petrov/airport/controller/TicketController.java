package com.petrov.airport.controller;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.RequestTicketDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseTicketDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public interface TicketController {
    ResponseTicketDTO get(@RequestParam int id);
    ResponseCompleted create(@RequestBody @Valid RequestTicketDTO requestTicketDTO);
    ResponseCompleted delete(@RequestBody @Valid RequestEntityDTO requestEntityDTO);
    ResponseCompleted deleteAllByFlight(@RequestBody @Valid RequestEntityDTO requestEntityDTO);
    List<ResponseTicketDTO> getTicketsBetweenDates(@RequestParam @NotNull LocalDateTime dateFrom,
                                                   @RequestParam @NotNull LocalDateTime dateTo);
}
