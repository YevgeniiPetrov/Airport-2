package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.ResponsePassengerDTO;
import com.petrov.airport.entity.Passenger;

public interface PassengerMapper {
    ResponsePassengerDTO passengerToMap(Passenger passenger);
}
