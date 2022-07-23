package com.petrov.airport.repository.impl;

import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.dao.PlaneDAO;
import com.petrov.airport.entity.Plane;
import com.petrov.airport.repository.PlaneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class PlaneRepositoryImpl implements PlaneRepository {
    private PlaneDAO planeDAO;

    @Override
    public GenericDAO<Plane> getGenericDAO() {
        return planeDAO;
    }

    @Override
    public Optional<Plane> getWithAirline(int id) {
        return planeDAO.getWithAirline(id);
    }
}
