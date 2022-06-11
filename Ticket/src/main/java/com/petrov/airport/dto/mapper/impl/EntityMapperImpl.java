package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.ResponseEntityDTO;
import com.petrov.airport.dto.mapper.EntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EntityMapperImpl implements EntityMapper {
    private ResponseEntityDTO responseEntityDTO;

    @Override
    public ResponseEntityDTO integerToMap(Integer id) {
        responseEntityDTO.setId(id);
        return responseEntityDTO;
    }
}
