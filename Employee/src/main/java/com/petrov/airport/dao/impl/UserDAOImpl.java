package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.UserDAO;
import com.petrov.airport.entity.User;
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
public class UserDAOImpl implements UserDAO {
    private DataBase<User> dataBase;

    @Override
    public DataBase<User> getDataBase() {
        return dataBase;
    }

    @Override
    public Optional<User> get(int id) {
        return dataBase.get(id, User.class);
    }

    @Override
    public List<User> getAll() {
        return dataBase.getAll(User.class);
    }

    @Override
    public Optional<User> get(String email) {
        User user = null;
        try (Session session = dataBase.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String queryStr = "select obj from User obj where obj.email = :email";
            Query query = session.createQuery(queryStr);
            query.setParameter("email", email);
            user = (User) query.getSingleResult();
            transaction.commit();
        } catch (NoResultException e) {
            throw new NoResultException(new StringBuilder()
                    .append("User with email ")
                    .append(email)
                    .append(" does not exist")
                    .toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }
}
