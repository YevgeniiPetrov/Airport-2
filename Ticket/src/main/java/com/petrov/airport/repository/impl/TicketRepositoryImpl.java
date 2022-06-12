package com.petrov.airport.repository.impl;

import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.dao.TicketDAO;
import com.petrov.airport.entity.Ticket;
import com.petrov.airport.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TicketRepositoryImpl implements TicketRepository {
    private TicketDAO ticketDAO;

    @Override
    public GenericDAO<Ticket> getGenericDAO() {
        return ticketDAO;
    }
}
