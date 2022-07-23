package com.petrov.airport;

import com.petrov.airport.configuration.Config;
import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.configuration.database.impl.DataBaseImpl;
import com.petrov.airport.dao.PlaneDAO;
import com.petrov.airport.dao.impl.PlaneDAOImpl;
import com.petrov.airport.entity.Plane;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPlaneApp {
    public static void main(String[] args) {
        // SpringApplication.run(SpringPlaneApp.class, args);
        Config config = new Config();
        DataBase<Plane> dataBase = new DataBaseImpl<>(config.getSessionFactory());
        PlaneDAO planeDAO = new PlaneDAOImpl(dataBase);
        System.out.println(planeDAO.get(17));
    }
}
