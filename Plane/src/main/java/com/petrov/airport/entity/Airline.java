package com.petrov.airport.entity;

import lombok.*;

import java.util.Objects;

@Getter
@ToString
@AllArgsConstructor
public class Airline {
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Airline airline = (Airline) o;
        return Objects.equals(id, airline.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
