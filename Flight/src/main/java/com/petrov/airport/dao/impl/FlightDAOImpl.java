package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.FlightDAO;
import com.petrov.airport.entity.Flight;
import com.petrov.airport.entity.Route;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            list = new ArrayList<>();
        }
        return list;
    }

    @Override
    public List<Flight> getAllByRoute(Route route) {
        return getAll().stream()
                .filter(flight -> flight.getId().equals(route.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Flight> getWithAirlines(int id) {
        Flight flight = null;
        try (Session session = dataBase.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String queryStr = "select distinct obj from Flight obj left join fetch obj.airlines a where obj.id = :id";
            Query query = session.createQuery(queryStr);
            query.setParameter("id", id);
            flight = (Flight) query.getSingleResult();
            transaction.commit();
        } catch (NoResultException e) {
            throw new NoResultException(new StringBuilder()
                    .append(Flight.class.getSimpleName())
                    .append(" with id ")
                    .append(id)
                    .append(" does not exist")
                    .toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(flight);
    }
}
