package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.ResponseStateDTO;
import com.petrov.airport.dto.impl.ResponseStateDTOImpl;
import com.petrov.airport.dto.mapper.StateMapper;
import com.petrov.airport.entity.State;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StateMapperImpl implements StateMapper {
    @Override
    public ResponseStateDTO stateToMap(State state) {
        return new ResponseStateDTOImpl().builder()
                .id(state.getId())
                .title(state.getTitle())
                .build();
    }
}
