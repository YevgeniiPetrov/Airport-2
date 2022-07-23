package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.ResponsePlaneDTO;
import com.petrov.airport.dto.impl.ResponsePlaneWithAirlineDTOImpl;
import com.petrov.airport.entity.Plane;

public interface PlaneMapper {
    ResponsePlaneDTO planeToMap(Plane plane);
    ResponsePlaneWithAirlineDTOImpl planeWithAirlineToMap(Plane plane);
}
