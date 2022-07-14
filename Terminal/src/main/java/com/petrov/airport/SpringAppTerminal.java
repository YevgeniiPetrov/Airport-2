package com.petrov.airport;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.configuration.database.impl.DataBaseImpl;
import com.petrov.airport.dao.FlightDAO;
import com.petrov.airport.dao.TerminalDAO;
import com.petrov.airport.dao.impl.FlightDAOImpl;
import com.petrov.airport.dao.impl.TerminalDAOImpl;
import com.petrov.airport.entity.Flight;
import com.petrov.airport.entity.Terminal;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SpringAppTerminal {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        DataBase<Terminal> dataBase = new DataBaseImpl<>(sessionFactory);
        TerminalDAO terminalDAO = new TerminalDAOImpl(dataBase);
        for (Flight flight : terminalDAO.getWithFlights(2).get().getFlights()) {
            System.out.println(flight);
        }
        System.out.println(terminalDAO.getWithFlights(2).get().getFlights().size());

        DataBase<Flight> dataBase1 = new DataBaseImpl<>(sessionFactory);
        FlightDAO flightDAO = new FlightDAOImpl(dataBase1);
        Flight flight = flightDAO.get(3).get();
        System.out.println(flight);
        flightDAO.delete(flight);
        System.out.println(flightDAO.getAll().size());
        System.out.println(flightDAO.getWithTerminals(46).get().getTerminals().size());
    }
}
