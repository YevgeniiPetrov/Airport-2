package com.petrov.airport.configuration.security;

import com.petrov.airport.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Getter
@AllArgsConstructor
public class SecurityUser implements UserDetails {
    private String username;
    private String password;
    private List<SimpleGrantedAuthority> authorities;
    private boolean isActive;

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static UserDetails fromUser(User user) {
        boolean isActive = user.getRemoved() == null || !user.getRemoved();
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                isActive,
                isActive,
                isActive,
                isActive,
                user.getRole().getAuthorities()
        );
    }
}
