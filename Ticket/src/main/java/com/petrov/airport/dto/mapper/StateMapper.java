package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.ResponseStateDTO;
import com.petrov.airport.entity.State;

public interface StateMapper {
    ResponseStateDTO stateToMap(State state);
}
