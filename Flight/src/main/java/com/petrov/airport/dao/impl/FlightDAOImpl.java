package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.FlightDAO;
import com.petrov.airport.entity.Flight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Getter
@AllArgsConstructor
public class FlightDAOImpl implements FlightDAO {
    private DataBase<Flight> dataBase;

    @Override
    public Optional<Flight> get(int id) {
        return dataBase.get(id, Flight.class);
    }

    @Override
    public List<Flight> getAll() {
        return dataBase.getAll(Flight.class);
    }

    @Override
    public List<Flight> getAllBetweenDates(LocalDateTime dateFrom, LocalDateTime dateTo) {
        List<Flight> list;
        try (Session session = dataBase.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            StringBuilder queryStr = new StringBuilder()
                    .append("select f ")
                    .append("from Flight f ")
                    .append("where f.departure between :dateFrom and :dateTo");
            Query query = session.createQuery(queryStr.toString());
            query.setParameter("dateFrom", dateFrom);
            query.setParameter("dateTo", dateTo);
            list = query.getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            list = new ArrayList<>();
        }
        return list;
    }
}
