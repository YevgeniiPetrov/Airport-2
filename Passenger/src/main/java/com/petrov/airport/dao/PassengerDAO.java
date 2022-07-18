package com.petrov.airport.dao;

import com.petrov.airport.entity.Passenger;

import java.util.List;

public interface PassengerDAO extends GenericDAO<Passenger> {
    List<Passenger> getAllByFlightIds(List<Integer> ids);
}
