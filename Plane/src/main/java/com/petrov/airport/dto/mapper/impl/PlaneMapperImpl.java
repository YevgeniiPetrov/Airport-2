package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.ResponsePlaneDTO;
import com.petrov.airport.dto.impl.ResponsePlaneDTOImpl;
import com.petrov.airport.dto.impl.ResponsePlaneWithAirlineDTOImpl;
import com.petrov.airport.dto.mapper.AirlineMapper;
import com.petrov.airport.dto.mapper.PlaneMapper;
import com.petrov.airport.entity.Plane;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlaneMapperImpl implements PlaneMapper {
    private AirlineMapper airlineMapper;

    @Override
    public ResponsePlaneDTO planeToMap(Plane plane) {
        return ResponsePlaneDTOImpl.builder()
                .id(plane.getId())
                .title(plane.getTitle())
                .build();
    }

    @Override
    public ResponsePlaneWithAirlineDTOImpl planeWithAirlineToMap(Plane plane) {
        return ResponsePlaneWithAirlineDTOImpl.builder()
                .id(plane.getId())
                .title(plane.getTitle())
                .airline(airlineMapper.airlineToMap(plane.getAirline()))
                .build();
    }
}
