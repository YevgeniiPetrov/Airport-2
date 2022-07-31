package com.petrov.airport.service;

import com.petrov.airport.dto.RequestEmployeeDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseEmployeeDTO;

public interface EmployeeService {
    ResponseEmployeeDTO get(int id);
    ResponseCompleted add(RequestEmployeeDTO requestEmployeeDTO);
}
