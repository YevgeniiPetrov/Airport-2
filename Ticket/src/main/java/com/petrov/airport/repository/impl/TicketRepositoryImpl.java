package com.petrov.airport.repository.impl;

import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.dao.TicketDAO;
import com.petrov.airport.entity.Flight;
import com.petrov.airport.entity.Ticket;
import com.petrov.airport.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TicketRepositoryImpl implements TicketRepository {
    private TicketDAO ticketDAO;

    @Override
    public GenericDAO<Ticket> getGenericDAO() {
        return ticketDAO;
    }

    @Override
    public List<Ticket> getAllByFlight(Flight flight) {
        return ticketDAO.getAllByFlight(flight);
    }
}
