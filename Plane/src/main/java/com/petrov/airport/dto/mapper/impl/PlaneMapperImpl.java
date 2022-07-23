package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.ResponsePlaneDTO;
import com.petrov.airport.dto.impl.ResponsePlaneDTOImpl;
import com.petrov.airport.dto.mapper.PlaneMapper;
import com.petrov.airport.entity.Plane;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class PlaneMapperImpl implements PlaneMapper {
    @Override
    public ResponsePlaneDTO planeToMap(Plane plane) {
        return ResponsePlaneDTOImpl.builder()
                .id(plane.getId())
                .title(plane.getTitle())
                .build();
    }
}
