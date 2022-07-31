package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.EmployeeController;
import com.petrov.airport.dto.RequestEmployeeDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseEmployeeDTO;
import com.petrov.airport.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmployeeControllerImpl implements EmployeeController {
    private EmployeeService employeeService;

    @Override
    @GetMapping("/employee/get")
    public ResponseEmployeeDTO get(@RequestParam int id) {
        return employeeService.get(id);
    }

    @Override
    @PostMapping("/employee/add")
    public ResponseCompleted add(RequestEmployeeDTO requestEmployeeDTO) {
        return employeeService.add(requestEmployeeDTO);
    }
}
