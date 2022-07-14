package com.petrov.airport.repository.impl;

import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.entity.Terminal;
import com.petrov.airport.repository.TerminalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TerminalRepositoryImpl implements TerminalRepository {
    private GenericDAO<Terminal> genericDAO;

    @Override
    public GenericDAO<Terminal> getGenericDAO() {
        return genericDAO;
    }
}
