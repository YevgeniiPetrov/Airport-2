package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.PostDAO;
import com.petrov.airport.entity.Post;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PostDAOImpl implements PostDAO {
    private DataBase<Post> dataBase;

    @Override
    public DataBase<Post> getDataBase() {
        return dataBase;
    }

    @Override
    public Optional<Post> get(int id) {
        return dataBase.get(id, Post.class);
    }

    @Override
    public List<Post> getAll() {
        return dataBase.getAll(Post.class);
    }

    @Override
    public Optional<Post> getWithEmployees(int id) {
        Post post = null;
        try (Session session = dataBase.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            String queryStr = "select distinct obj from Terminal obj left join fetch obj.flights f where obj.id = :id";
            Query query = session.createQuery(queryStr);
            query.setParameter("id", id);
            post = (Post) query.getSingleResult();
            transaction.commit();
        } catch (NoResultException e) {
            throw new NoResultException(new StringBuilder()
                    .append("Terminal with id ")
                    .append(id)
                    .append(" does not exist")
                    .toString());
        } catch (Exception e) {}
        return Optional.ofNullable(post);
    }
}
