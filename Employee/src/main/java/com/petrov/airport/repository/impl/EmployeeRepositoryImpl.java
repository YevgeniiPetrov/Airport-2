package com.petrov.airport.repository.impl;

import com.petrov.airport.dao.EmployeeDAO;
import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.entity.Employee;
import com.petrov.airport.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private EmployeeDAO employeeDAO;

    @Override
    public GenericDAO<Employee> getGenericDAO() {
        return employeeDAO;
    }
}
