package com.petrov.airport.service;

import com.petrov.airport.dto.*;

public interface PassengerService {
    ResponsePassengerDTO get(int id);
    ResponseCompleted add(RequestPassengerDTO requestPassengerDTO);
    ResponseCompleted addTickets(RequestPassengerTicketsDTO requestPassengerTicketsDTO);
    ResponseCompleted delete(RequestEntityDTO requestEntityDTO);
}
