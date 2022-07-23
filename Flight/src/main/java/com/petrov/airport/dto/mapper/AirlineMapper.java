package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.ResponseAirlineDTO;
import com.petrov.airport.entity.Airline;

public interface AirlineMapper {
    ResponseAirlineDTO airlineToMap(Airline airline);
}
