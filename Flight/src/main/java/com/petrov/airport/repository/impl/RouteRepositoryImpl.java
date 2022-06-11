package com.petrov.airport.repository.impl;

import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.dao.RouteDAO;
import com.petrov.airport.entity.Route;
import com.petrov.airport.repository.RouteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class RouteRepositoryImpl implements RouteRepository {
    private RouteDAO routeDAO;

    @Override
    public GenericDAO<Route> getGenericDAO() {
        return routeDAO;
    }
}
