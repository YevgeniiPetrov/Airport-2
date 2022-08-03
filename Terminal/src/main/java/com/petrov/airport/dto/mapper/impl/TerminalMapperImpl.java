package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.RequestTerminalDTO;
import com.petrov.airport.dto.mapper.TerminalMapper;
import com.petrov.airport.entity.Terminal;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class TerminalMapperImpl implements TerminalMapper {
    @Override
    public Terminal mapToTerminal(RequestTerminalDTO requestTerminalDTO) {
        return Terminal.builder()
                .title(requestTerminalDTO.getTitle())
                .build();
    }
}
