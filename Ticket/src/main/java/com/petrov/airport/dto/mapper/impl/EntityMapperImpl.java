package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.ResponseEntityDTO;
import com.petrov.airport.dto.impl.ResponseEntityDTOImpl;
import com.petrov.airport.dto.mapper.EntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EntityMapperImpl implements EntityMapper {
    @Override
    public ResponseEntityDTO integerToMap(Integer id) {
        return new ResponseEntityDTOImpl().builder()
                .id(id)
                .build();
    }

    @Override
    public Integer mapToInteger(RequestEntityDTO requestEntityDTO) {
        return requestEntityDTO.getId();
    }
}
