package com.petrov.airport.service;

import com.petrov.airport.dto.ResponsePassengerDTO;

public interface PassengerService {
    ResponsePassengerDTO get(int id);
}
