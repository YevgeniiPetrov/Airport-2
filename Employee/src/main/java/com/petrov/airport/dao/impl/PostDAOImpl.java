package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.PostDAO;
import com.petrov.airport.entity.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
}
