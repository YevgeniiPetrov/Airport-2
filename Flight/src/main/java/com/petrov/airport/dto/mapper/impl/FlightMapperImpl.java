package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.ResponseFlightDTO;
import com.petrov.airport.dto.impl.ResponseFlightDTOImpl;
import com.petrov.airport.dto.mapper.FlightMapper;
import com.petrov.airport.dto.mapper.RouteMapper;
import com.petrov.airport.dto.mapper.StateMapper;
import com.petrov.airport.entity.Flight;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class FlightMapperImpl implements FlightMapper {
    private RouteMapper routeMapper;
    private StateMapper stateMapper;

    @Override
    public ResponseFlightDTO flightToMap(Flight flight) {
        return new ResponseFlightDTOImpl().builder()
                .id(flight.getId())
                .departure(flight.getDeparture())
                .duration(flight.getDuration())
                .route(routeMapper.routeToMap(flight.getRoute()))
                .state(stateMapper.stateToMap(flight.getState()))
                .build();
    }

    @Override
    public List<ResponseFlightDTO> flightsToMap(List<Flight> flights) {
        List<ResponseFlightDTO> flightDTOList = new ArrayList<>();
        flights.stream()
                .map(this::flightToMap)
                .forEach(flightDTOList::add);
        return flightDTOList;
    }
}
