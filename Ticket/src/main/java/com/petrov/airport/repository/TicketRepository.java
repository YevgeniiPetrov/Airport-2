package com.petrov.airport.repository;

import com.petrov.airport.entity.Flight;
import com.petrov.airport.entity.Ticket;

import java.util.List;

public interface TicketRepository extends GenericRepository<Ticket> {
    List<Ticket> getAllByFlight(Flight flight);
}
