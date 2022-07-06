package com.petrov.airport.dao;

import com.petrov.airport.entity.Flight;
import com.petrov.airport.entity.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketDAO extends GenericDAO<Ticket> {
    List<Ticket> getAllByFlight(Flight flight);
    List<Ticket> getAllBetweenDates(LocalDateTime dateFrom, LocalDateTime dateTo);
}
