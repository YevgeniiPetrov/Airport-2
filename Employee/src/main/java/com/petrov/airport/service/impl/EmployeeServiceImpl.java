package com.petrov.airport.service.impl;

import com.petrov.airport.dto.RequestEmployeeDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseEmployeeDTO;
import com.petrov.airport.dto.mapper.EmployeeMapper;
import com.petrov.airport.repository.EmployeeRepository;
import com.petrov.airport.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;
    private ResponseCompleted responseCompleted;

    @Override
    public ResponseEmployeeDTO get(int id) {
        return employeeMapper.employeeToMap(employeeRepository.get(id).get());
    }

    @Override
    public ResponseCompleted add(RequestEmployeeDTO requestEmployeeDTO) {
        employeeRepository.add(employeeMapper.mapToEmployee(requestEmployeeDTO));
        return responseCompleted;
    }
}
