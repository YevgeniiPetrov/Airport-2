package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.TicketDAO;
import com.petrov.airport.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Getter
@AllArgsConstructor
public class TicketDAOImpl implements TicketDAO {
    private DataBase<Ticket> dataBase;

    @Override
    public Optional<Ticket> get(int id) {
        return dataBase.get(id, Ticket.class);
    }

    @Override
    public List<Ticket> getAll() {
        return dataBase.getAll(Ticket.class);
    }
}
