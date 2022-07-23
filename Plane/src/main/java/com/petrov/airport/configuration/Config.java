package com.petrov.airport.configuration;

import org.hibernate.SessionFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
    @Bean
    public SessionFactory getSessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure()
                .buildSessionFactory();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
