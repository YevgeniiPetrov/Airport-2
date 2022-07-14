package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.TerminalDAO;
import com.petrov.airport.entity.Flight;
import com.petrov.airport.entity.Terminal;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.ArrayList;
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

    @Override
    public Optional<Terminal> getWithFlights(int id) {
        Session session = dataBase.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        StringBuilder queryStr = new StringBuilder()
                .append("select distinct obj from ")
                .append(Terminal.class.getSimpleName())
                .append(" obj left join fetch obj.flights f ")
                .append("where obj.id = :id");
        Query query = session.createQuery(queryStr.toString());
        query.setParameter("id", id);
        Terminal terminal = (Terminal) query.getSingleResult();
        transaction.commit();
        session.close();
        return Optional.ofNullable(terminal);
    }
}
