package com.petrov.airport.service;

import com.petrov.airport.dto.RequestTerminalDTO;
import com.petrov.airport.dto.ResponseCompleted;

import java.util.List;

public interface TerminalService {
    List<Integer> getAllFlightIds(int id);
    ResponseCompleted add(RequestTerminalDTO requestTerminalDTO);
}
