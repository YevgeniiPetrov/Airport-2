package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.ResponseRouteDTO;
import com.petrov.airport.dto.mapper.RouteMapper;
import com.petrov.airport.entity.Route;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RouteMapperImpl implements RouteMapper {
    private ResponseRouteDTO responseRouteDTO;

    @Override
    public ResponseRouteDTO routeToMap(Route route) {
        responseRouteDTO.setId(route.getId());
        responseRouteDTO.setFrom(route.getFrom());
        responseRouteDTO.setTo(route.getTo());
        return responseRouteDTO;
    }
}
