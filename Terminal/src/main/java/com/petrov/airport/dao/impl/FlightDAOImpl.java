package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.FlightDAO;
import com.petrov.airport.entity.Flight;
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
public class FlightDAOImpl implements FlightDAO {
    private DataBase<Flight> dataBase;

    @Override
    public DataBase<Flight> getDataBase() {
        return dataBase;
    }

    @Override
    public Optional<Flight> get(int id) {
        return dataBase.get(id, Flight.class);
    }

    @Override
    public List<Flight> getAll() {
        return dataBase.getAll(Flight.class);
    }

    @Override
    public Optional<Flight> getWithTerminals(int id) {
        Flight flight = null;
        try (Session session = dataBase.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            StringBuilder queryStr = new StringBuilder()
                    .append("select distinct obj from Flight ")
                    .append("obj left join fetch obj.terminals t ")
                    .append("where obj.id = :id");
            Query query = session.createQuery(queryStr.toString());
            query.setParameter("id", id);
            flight = (Flight) query.getSingleResult();
            transaction.commit();
        } catch (NoResultException e) {
            throw new NoResultException(new StringBuilder()
                    .append("Flight with id ")
                    .append(id)
                    .append(" does not exist")
                    .toString());
        } catch (Exception e) {}
        return Optional.ofNullable(flight);
    }
}
