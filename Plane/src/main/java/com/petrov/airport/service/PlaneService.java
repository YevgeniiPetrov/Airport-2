package com.petrov.airport.service;

import com.petrov.airport.dto.ResponsePlaneDTO;
import com.petrov.airport.dto.ResponsePlaneWithAirlineDTO;

import java.util.List;

public interface PlaneService {
    ResponsePlaneDTO get(int id);
    ResponsePlaneWithAirlineDTO getWithAirline(int id);
    List<ResponsePlaneDTO> getAllByAirline(int airlineId);
}
