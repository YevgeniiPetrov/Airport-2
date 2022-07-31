package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.RequestEmployeeDTO;
import com.petrov.airport.dto.ResponseEmployeeDTO;
import com.petrov.airport.dto.impl.ResponseEmployeeDTOImpl;
import com.petrov.airport.dto.mapper.EmployeeMapper;
import com.petrov.airport.dto.mapper.PostMapper;
import com.petrov.airport.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmployeeMapperImpl implements EmployeeMapper {
    private PostMapper postMapper;

    @Override
    public ResponseEmployeeDTO employeeToMap(Employee employee) {
        return ResponseEmployeeDTOImpl.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .birthdate(employee.getBirthdate())
                .build();
    }

    @Override
    public Employee mapToEmployee(RequestEmployeeDTO requestEmployeeDTO) {
        return Employee.builder()
                .firstName(requestEmployeeDTO.getFirstName())
                .lastName(requestEmployeeDTO.getLastName())
                .birthdate(requestEmployeeDTO.getBirthdate())
                .post(postMapper.mapToPost(requestEmployeeDTO.getPost()))
                .build();
    }
}
