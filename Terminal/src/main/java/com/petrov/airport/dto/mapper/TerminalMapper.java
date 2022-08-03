package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.RequestTerminalDTO;
import com.petrov.airport.entity.Terminal;

public interface TerminalMapper {
    Terminal mapToTerminal(RequestTerminalDTO requestTerminalDTO);
}
