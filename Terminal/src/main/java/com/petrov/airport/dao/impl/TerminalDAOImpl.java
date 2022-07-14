package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.TerminalDAO;
import com.petrov.airport.entity.Terminal;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import javax.persistence.Query;
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
        Terminal terminal = null;
        try (Session session = dataBase.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            String queryStr = "select distinct obj from Terminal obj left join fetch obj.flights f where obj.id = :id";
            Query query = session.createQuery(queryStr);
            query.setParameter("id", id);
            terminal = (Terminal) query.getSingleResult();
            transaction.commit();
        } catch (NoResultException e) {
            throw new NoResultException(new StringBuilder()
                    .append("Terminal with id ")
                    .append(id)
                    .append(" does not exist")
                    .toString());
        } catch (Exception e) {}
        return Optional.ofNullable(terminal);
    }
}
