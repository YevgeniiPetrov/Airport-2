package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.ResponseAirlineDTO;
import com.petrov.airport.dto.impl.ResponseAirlineDTOImpl;
import com.petrov.airport.dto.mapper.AirlineMapper;
import com.petrov.airport.entity.Airline;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class AirlineMapperImpl implements AirlineMapper {
    @Override
    public ResponseAirlineDTO airlineToMap(Airline airline) {
        return ResponseAirlineDTOImpl.builder()
                .id(airline.getId())
                .title(airline.getTitle())
                .rating(airline.getRating())
                .build();
    }
}
