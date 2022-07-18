package com.petrov.airport.repository.impl;

import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.dao.PassengerDAO;
import com.petrov.airport.entity.Passenger;
import com.petrov.airport.repository.PassengerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PassengerRepositoryImpl implements PassengerRepository {
    private PassengerDAO passengerDAO;

    @Override
    public GenericDAO<Passenger> getGenericDAO() {
        return passengerDAO;
    }

    @Override
    public List<Passenger> getAllByFlightIds(List<Integer> ids) {
        return passengerDAO.getAllByFlightIds(ids);
    }
}
