package com.petrov.airport.repository.impl;

import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.dao.StateDAO;
import com.petrov.airport.entity.State;
import com.petrov.airport.repository.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class StateRepositoryImpl implements StateRepository {
    private StateDAO stateDAO;

    @Override
    public GenericDAO<State> getGenericDAO() {
        return stateDAO;
    }
}
