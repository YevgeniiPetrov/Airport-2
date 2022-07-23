package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.AirlineDAO;
import com.petrov.airport.entity.Airline;
import com.petrov.airport.entity.Plane;
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
public class AirlineDAOImpl implements AirlineDAO {
    private DataBase<Airline> dataBase;

    @Override
    public DataBase<Airline> getDataBase() {
        return dataBase;
    }

    @Override
    public Optional<Airline> get(int id) {
        return dataBase.get(id, Airline.class);
    }

    @Override
    public List<Airline> getAll() {
        return dataBase.getAll(Airline.class);
    }

    @Override
    public Optional<Airline> getWithPlanes(int id) {
        Airline airline = null;
        try (Session session = dataBase.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            String queryStr = "select distinct obj from Airline obj left join fetch obj.planes p where obj.id = :id";
            Query query = session.createQuery(queryStr);
            query.setParameter("id", id);
            airline = (Airline) query.getSingleResult();
            transaction.commit();
        } catch (NoResultException e) {
            throw new NoResultException(new StringBuilder()
                    .append("Airline with id ")
                    .append(id)
                    .append(" does not exist")
                    .toString());
        } catch (Exception e) {}
        return Optional.ofNullable(airline);
    }
}
