package com.petrov.airport.configuration;


import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.impl.ResponseCompletedImpl;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public SessionFactory getSessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure()
                .buildSessionFactory();
    }

    @Bean
    public ResponseCompleted getResponseCompleted() {
        return new ResponseCompletedImpl("Operation completed successfully");
    }
}
