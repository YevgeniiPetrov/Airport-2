package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.ResponseEntityDTO;

public interface EntityMapper {
    ResponseEntityDTO integerToMap(Integer id);
    Integer mapToInteger(RequestEntityDTO requestEntityDTO);
}
