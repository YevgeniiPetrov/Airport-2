package com.petrov.airport.controller;

import com.petrov.airport.dto.RequestEmployeeDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseEmployeeDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface EmployeeController {
    ResponseEmployeeDTO get(@RequestParam int id);
    ResponseCompleted add(@RequestBody RequestEmployeeDTO requestEmployeeDTO);
}
