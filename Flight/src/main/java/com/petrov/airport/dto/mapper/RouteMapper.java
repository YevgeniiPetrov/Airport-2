package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.ResponseRouteDTO;
import com.petrov.airport.entity.Route;

public interface RouteMapper {
    ResponseRouteDTO routeToMap(Route route);
}
