package com.petrov.airport.service;

import com.petrov.airport.dto.ResponsePlaneDTO;
import com.petrov.airport.dto.ResponsePlaneWithAirlineDTO;

public interface PlaneService {
    ResponsePlaneDTO get(int id);
    ResponsePlaneWithAirlineDTO getWithAirline(int id);
}
