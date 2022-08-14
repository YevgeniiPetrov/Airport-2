package com.petrov.airport.service.impl;

import com.petrov.airport.configuration.security.SecurityUser;
import com.petrov.airport.entity.User;
import com.petrov.airport.repository.UserRepository;
import com.petrov.airport.service.UserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.get(email).orElseThrow(() ->
                new UsernameNotFoundException("User does not exist"));
        return SecurityUser.fromUser(user);
    }
}
