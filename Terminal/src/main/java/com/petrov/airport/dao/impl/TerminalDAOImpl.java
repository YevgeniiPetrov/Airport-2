package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.TerminalDAO;
import com.petrov.airport.entity.Terminal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class TerminalDAOImpl implements TerminalDAO {
    private DataBase<Terminal> dataBase;

    @Override
    public DataBase<Terminal> getDataBase() {
        return dataBase;
    }

    @Override
    public Optional<Terminal> get(int id) {
        return dataBase.get(id, Terminal.class);
    }

    @Override
    public List<Terminal> getAll() {
        return dataBase.getAll(Terminal.class);
    }
}
