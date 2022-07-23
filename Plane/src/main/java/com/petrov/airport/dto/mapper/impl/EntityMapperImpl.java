package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.ResponseEntityDTO;
import com.petrov.airport.dto.impl.ResponseEntityDTOImpl;
import com.petrov.airport.dto.mapper.EntityMapper;
import com.petrov.airport.entity.Essence;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class EntityMapperImpl implements EntityMapper {
    @Override
    public ResponseEntityDTO entityToMap(Essence essence) {
        return ResponseEntityDTOImpl.builder()
                .id(essence.getId())
                .build();
    }
}
