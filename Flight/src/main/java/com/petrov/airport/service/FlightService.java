package com.petrov.airport.service;

import com.petrov.airport.dto.*;
import com.petrov.airport.entity.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    ResponseFlightDTO get(int id);
    List<ResponseFlightDTO> getFlightsBetweenDates(LocalDateTime dateFrom, LocalDateTime dateTo);
    ResponseCompleted delete(Flight flight);
    ResponseCompleted delete(RequestEntityDTO requestEntityDTO);
    ResponseCompleted update(RequestFlightChangeDeparture requestFlightChangeDeparture);
    List<ResponseFlightDTO> getAllByTerminal(int id);
    ResponseFlightWithAirlinesDTO getWithAirlines(int id);
}
