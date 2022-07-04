package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.ResponseRouteDTO;
import com.petrov.airport.dto.impl.ResponseRouteDTOImpl;
import com.petrov.airport.dto.mapper.RouteMapper;
import com.petrov.airport.entity.Route;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RouteMapperImpl implements RouteMapper {
    @Override
    public ResponseRouteDTO routeToMap(Route route) {
        return ResponseRouteDTOImpl.builder()
                .id(route.getId())
                .from(route.getFrom())
                .to(route.getTo())
                .build();
    }
}
