package com.petrov.airport.repository.impl;

import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.dao.TerminalDAO;
import com.petrov.airport.entity.Terminal;
import com.petrov.airport.repository.TerminalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class TerminalRepositoryImpl implements TerminalRepository {
    private GenericDAO<Terminal> genericDAO;
    private TerminalDAO terminalDAO;

    @Override
    public GenericDAO<Terminal> getGenericDAO() {
        return genericDAO;
    }

    @Override
    public Optional<Terminal> getWithFlights(int id) {
        return terminalDAO.getWithFlights(id);
    }
}
