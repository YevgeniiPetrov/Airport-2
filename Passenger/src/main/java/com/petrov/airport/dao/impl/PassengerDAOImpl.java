package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.PassengerDAO;
import com.petrov.airport.entity.Passenger;
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
public class PassengerDAOImpl implements PassengerDAO {
    private DataBase<Passenger> dataBase;

    @Override
    public Optional<Passenger> get(int id) {
        return dataBase.get(id, Passenger.class);
    }

    @Override
    public List<Passenger> getAll() {
        return dataBase.getAll(Passenger.class);
    }

    @Override
    public List<Passenger> getAllByFlightIds(List<Integer> ids) {
        List<Passenger> passengers;
        try (Session session = dataBase.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String queryStr = "select distinct obj from Passenger left join fetch obj.flights f where f.id in :ids";
            Query query = session.createQuery(queryStr.toString());
            passengers = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            passengers = new ArrayList<>();
        }
        return passengers;
    }
}
