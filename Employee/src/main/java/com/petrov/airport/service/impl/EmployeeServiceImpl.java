package com.petrov.airport.service.impl;

import com.petrov.airport.dto.RequestEmployeeDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseEmployeeDTO;
import com.petrov.airport.dto.mapper.EmployeeMapper;
import com.petrov.airport.entity.Employee;
import com.petrov.airport.repository.EmployeeRepository;
import com.petrov.airport.repository.PostRepository;
import com.petrov.airport.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;
    private ResponseCompleted responseCompleted;
    private PostRepository postRepository;

    @Override
    public ResponseEmployeeDTO get(int id) {
        return employeeMapper.employeeToMap(employeeRepository.get(id).get());
    }

    @Override
    public ResponseCompleted add(RequestEmployeeDTO requestEmployeeDTO) {
        Employee employee = employeeMapper.mapToEmployee(requestEmployeeDTO);
        employee.setPost(postRepository.get(requestEmployeeDTO.getPost().getId()).get());
        employeeRepository.add(employee);
        return responseCompleted;
    }
}
