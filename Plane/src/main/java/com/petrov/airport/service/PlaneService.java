package com.petrov.airport.service;

import com.petrov.airport.dto.ResponsePlaneDTO;

public interface PlaneService {
    ResponsePlaneDTO get(int id);
}
