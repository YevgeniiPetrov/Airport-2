package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.ResponseAirlineDTO;
import com.petrov.airport.dto.impl.ResponseAirlineDTOImpl;
import com.petrov.airport.dto.impl.ResponseAirlineWithPlanesDTOImpl;
import com.petrov.airport.dto.mapper.AirlineMapper;
import com.petrov.airport.dto.mapper.PlaneMapper;
import com.petrov.airport.entity.Airline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AirlineMapperImpl implements AirlineMapper {
    private PlaneMapper planeMapper;

    @Override
    public ResponseAirlineDTO airlineToMap(Airline airline) {
        return ResponseAirlineDTOImpl.builder()
                .id(airline.getId())
                .title(airline.getTitle())
                .rating(airline.getRating())
                .build();
    }

    @Override
    public ResponseAirlineWithPlanesDTOImpl airlineWithPlanesToMap(Airline airline) {
        return ResponseAirlineWithPlanesDTOImpl.builder()
                .id(airline.getId())
                .title(airline.getTitle())
                .rating(airline.getRating())
                .planes(airline.getPlanes().stream()
                        .map(planeMapper::planeToMap)
                        .collect(Collectors.toList()))
                .build();
    }
}
