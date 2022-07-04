package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.TicketDAO;
import com.petrov.airport.entity.Flight;
import com.petrov.airport.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.ArrayList;
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

    @Override
    public List<Ticket> getAllByFlight(Flight flight) {
        List<Ticket> tickets;
        try (Session session = dataBase.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            StringBuilder queryStr = new StringBuilder()
                    .append("select obj from ")
                    .append(Ticket.class.getSimpleName())
                    .append(" obj ")
                    .append("where obj.flightId = ")
                    .append(flight.getId());
            Query query = session.createQuery(queryStr.toString());
            tickets = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tickets = new ArrayList<>();
        }
        return tickets;
    }
}
