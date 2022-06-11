package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.ResponseFlightDTO;
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
    private ResponseFlightDTO responseFlightDTO;
    private RouteMapper routeMapper;
    private StateMapper stateMapper;

    @Override
    public ResponseFlightDTO flightToMap(Flight flight) {
        responseFlightDTO.setId(flight.getId());
        responseFlightDTO.setDeparture(flight.getDeparture());
        responseFlightDTO.setDuration(flight.getDuration());
        responseFlightDTO.setRoute(routeMapper.routeToMap(flight.getRoute()));
        responseFlightDTO.setState(stateMapper.stateToMap(flight.getState()));
        return responseFlightDTO;
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
