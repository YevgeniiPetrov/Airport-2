package com.petrov.airport.service;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.RequestTicketDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseTicketDTO;
import com.petrov.airport.entity.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketService {
    ResponseTicketDTO get(int id);
    ResponseTicketDTO get(Ticket ticket);
    ResponseCompleted add(RequestTicketDTO requestTicketDTO);
    ResponseCompleted add(List<RequestTicketDTO> requestTicketDTOList);
    ResponseCompleted delete(RequestEntityDTO requestEntityDTO);
    ResponseCompleted deleteAllByFlight(RequestEntityDTO requestEntityDTO);
    List<ResponseTicketDTO> getTicketsBetweenDates(LocalDateTime dateFrom, LocalDateTime dateTo);
}
