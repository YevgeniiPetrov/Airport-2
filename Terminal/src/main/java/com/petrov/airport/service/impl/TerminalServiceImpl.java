package com.petrov.airport.service.impl;

import com.petrov.airport.dto.RequestTerminalDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.mapper.TerminalMapper;
import com.petrov.airport.entity.Flight;
import com.petrov.airport.repository.TerminalRepository;
import com.petrov.airport.service.TerminalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TerminalServiceImpl implements TerminalService {
    private TerminalRepository terminalRepository;
    private ResponseCompleted responseCompleted;
    private TerminalMapper terminalMapper;

    @Override
    public List<Integer> getAllFlightIds(int id) {
        return terminalRepository.getWithFlights(id).get().getFlights().stream()
                .map(Flight::getId)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseCompleted add(RequestTerminalDTO requestTerminalDTO) {
        terminalRepository.add(terminalMapper.mapToTerminal(requestTerminalDTO));
        return responseCompleted;
    }
}
