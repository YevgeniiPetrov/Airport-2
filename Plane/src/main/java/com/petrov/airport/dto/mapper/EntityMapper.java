package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.ResponseEntityDTO;
import com.petrov.airport.entity.Essence;

public interface EntityMapper {
    ResponseEntityDTO entityToMap(Essence essence);
}
