package com.petrov.airport.service;

import com.petrov.airport.dto.RequestPassengerDTO;
import com.petrov.airport.dto.RequestPassengerTicketsDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponsePassengerDTO;

public interface PassengerService {
    ResponsePassengerDTO get(int id);
    ResponseCompleted add(RequestPassengerDTO requestPassengerDTO);
    ResponseCompleted addTickets(RequestPassengerTicketsDTO requestPassengerTicketsDTO);
}
