package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.mapper.EntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EntityMapperImpl implements EntityMapper {
    @Override
    public RequestEntityDTO integerToMap(Integer id) {
        return RequestEntityDTO.builder()
                .id(id)
                .build();
    }
}
