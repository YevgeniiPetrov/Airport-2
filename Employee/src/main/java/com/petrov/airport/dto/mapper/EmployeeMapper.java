package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.ResponseEmployeeDTO;
import com.petrov.airport.entity.Employee;

public interface EmployeeMapper {
    ResponseEmployeeDTO employeeToMap(Employee employee);
}
