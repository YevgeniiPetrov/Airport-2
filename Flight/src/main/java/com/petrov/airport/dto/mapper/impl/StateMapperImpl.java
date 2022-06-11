package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.ResponseStateDTO;
import com.petrov.airport.dto.mapper.StateMapper;
import com.petrov.airport.entity.State;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StateMapperImpl implements StateMapper {
    private ResponseStateDTO responseStateDTO;

    @Override
    public ResponseStateDTO stateToMap(State state) {
        responseStateDTO.setId(state.getId());
        responseStateDTO.setTitle(state.getTitle());
        return responseStateDTO;
    }
}
