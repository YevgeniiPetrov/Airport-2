package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.ResponseFlightDTO;
import com.petrov.airport.entity.Flight;

public interface FlightMapper {
    ResponseFlightDTO flightToMap(Flight flight);
}
