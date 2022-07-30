package com.petrov.airport.controller;

import com.petrov.airport.dto.ResponseEmployeeDTO;
import org.springframework.web.bind.annotation.RequestParam;

public interface EmployeeController {
    ResponseEmployeeDTO get(@RequestParam int id);
}
