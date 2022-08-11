package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.EmployeeController;
import com.petrov.airport.dto.RequestEmployeeDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseEmployeeDTO;
import com.petrov.airport.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeControllerImpl implements EmployeeController {
    private EmployeeService employeeService;

    @Override
    @GetMapping("/get")
    @PreAuthorize("hasAuthority('read')")
    public ResponseEmployeeDTO get(@RequestParam int id) {
        return employeeService.get(id);
    }

    @Override
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('write')")
    public ResponseCompleted add(RequestEmployeeDTO requestEmployeeDTO) {
        return employeeService.add(requestEmployeeDTO);
    }
}
