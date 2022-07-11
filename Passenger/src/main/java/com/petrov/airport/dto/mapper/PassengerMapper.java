package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.*;
import com.petrov.airport.entity.Passenger;

import java.util.List;

public interface PassengerMapper {
    ResponsePassengerDTO passengerToMap(Passenger passenger);
    Passenger mapToPassenger(RequestPassengerDTO requestPassengerDTO);
    List<RequestTicketDTO> mapToMap(Passenger passenger, RequestPassengerTicketsDTO requestPassengerTicketsDTO);
}
