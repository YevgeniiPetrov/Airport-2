package com.petrov.airport.configuration.security;

import javax.naming.AuthenticationException;

public class JWTAuthenticationException extends AuthenticationException {
    public JWTAuthenticationException(String explanation) {
        super(explanation);
    }
}
