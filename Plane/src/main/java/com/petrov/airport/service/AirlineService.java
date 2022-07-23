package com.petrov.airport.service;

import com.petrov.airport.dto.ResponseAirlineDTO;
import com.petrov.airport.entity.Airline;

public interface AirlineService {
    Airline get(int id);
    ResponseAirlineDTO getResponseAirlineDTO(int id);
}
