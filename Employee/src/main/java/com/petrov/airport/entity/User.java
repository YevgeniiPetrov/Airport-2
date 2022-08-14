package com.petrov.airport.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@Getter
@ToString
@AllArgsConstructor
public class User extends Essence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @ToString.Exclude
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @ToString.Exclude
    private Boolean removed;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
