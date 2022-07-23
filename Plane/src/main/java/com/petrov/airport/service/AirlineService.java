package com.petrov.airport.service;

import com.petrov.airport.dto.ResponseAirlineDTO;

public interface AirlineService {
    ResponseAirlineDTO get(int id);
}
