package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.EmployeeDAO;
import com.petrov.airport.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class EmployeeDAOImpl implements EmployeeDAO {
    private DataBase<Employee> dataBase;

    @Override
    public DataBase<Employee> getDataBase() {
        return dataBase;
    }

    @Override
    public Optional<Employee> get(int id) {
        return dataBase.get(id, Employee.class);
    }

    @Override
    public List<Employee> getAll() {
        return dataBase.getAll(Employee.class);
    }
}
