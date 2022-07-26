package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.ResponseFlightDTO;
import com.petrov.airport.dto.ResponseFlightWithAirlinesDTO;
import com.petrov.airport.entity.Flight;

import java.util.List;

public interface FlightMapper {
    ResponseFlightDTO flightToMap(Flight flight);
    List<ResponseFlightDTO> flightsToMap(List<Flight> flights);
    Flight mapToFlight(RequestEntityDTO requestEntityDTO);
    ResponseFlightWithAirlinesDTO flightWithAirlinesToMap(Flight flight);
}
