package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.PlaneDAO;
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
public class PlaneDAOImpl implements PlaneDAO {
    private DataBase<Plane> dataBase;

    @Override
    public DataBase<Plane> getDataBase() {
        return dataBase;
    }

    @Override
    public Optional<Plane> get(int id) {
        return dataBase.get(id, Plane.class);
    }

    @Override
    public List<Plane> getAll() {
        return dataBase.getAll(Plane.class);
    }

    @Override
    public Optional<Plane> getWithAirline(int id) {
        Plane plane = null;
        try (Session session = dataBase.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            String queryStr = "select distinct obj from Plane obj left join fetch obj.airline a where obj.id = :id";
            Query query = session.createQuery(queryStr);
            query.setParameter("id", id);
            plane = (Plane) query.getSingleResult();
            transaction.commit();
        } catch (NoResultException e) {
            throw new NoResultException(new StringBuilder()
                    .append("Airline with id ")
                    .append(id)
                    .append(" does not exist")
                    .toString());
        } catch (Exception e) {}
        return Optional.ofNullable(plane);
    }
}
