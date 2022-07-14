package com.petrov.airport.service;

import com.petrov.airport.dto.*;

import java.util.List;

public interface PassengerService {
    ResponsePassengerDTO get(int id);
    ResponseCompleted add(RequestPassengerDTO requestPassengerDTO);
    ResponseCompleted addTickets(RequestPassengerTicketsDTO requestPassengerTicketsDTO);
    ResponseCompleted delete(RequestEntityDTO requestEntityDTO);
    List<ResponsePassengerDTO> getAllByTerminal(int id);
}
