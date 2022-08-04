package com.petrov.airport.service;

import com.petrov.airport.dto.ResponseAirlineDTO;
import com.petrov.airport.entity.Airline;

import java.util.Optional;

public interface AirlineService {
    Airline get(int id);
    Optional<Airline> getWithPlanes(int id);
    ResponseAirlineDTO getResponseAirlineDTO(int id);
}
