package com.petrov.airport.configuration.database.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.entity.Essence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Getter
@AllArgsConstructor
public class DataBaseImpl<T extends Essence> implements DataBase<T> {
    private SessionFactory sessionFactory;

    @Override
    public T add(T object) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public Optional<T> get(int id, Class<T> type) {
        T object = null;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            StringBuilder queryStr = new StringBuilder()
                    .append("select obj from ")
                    .append(type.getSimpleName())
                    .append(" obj ")
                    .append("where obj.id = :id");
            Query query = session.createQuery(queryStr.toString());
            query.setParameter("id", id);
            object = (T) query.getSingleResult();
            transaction.commit();
        } catch (NoResultException e) {
            throw new NoResultException(new StringBuilder()
                    .append(type.getSimpleName())
                    .append(" with id ")
                    .append(id)
                    .append(" does not exist")
                    .toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(object);
    }

    @Override
    public T update(T object) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public Boolean delete(T object) {
        object.setRemoved(true);
        update(object);
        return object.getRemoved();
    }

    @Override
    public List<T> getAll(Class<T> type) {
        List<T> objects;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            StringBuilder queryStr = new StringBuilder()
                    .append("select obj from ")
                    .append(type.getSimpleName())
                    .append(" obj ");
            Query query = session.createQuery(queryStr.toString());
            objects = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            objects = new ArrayList<>();
        }
        return objects;
    }
}
