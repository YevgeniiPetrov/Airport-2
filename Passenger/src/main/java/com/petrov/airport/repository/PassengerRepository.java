package com.petrov.airport.repository;

import com.petrov.airport.entity.Passenger;

import java.util.List;

public interface PassengerRepository extends GenericRepository<Passenger> {
    List<Passenger> getAllByFlightIds(List<Integer> ids);
}
