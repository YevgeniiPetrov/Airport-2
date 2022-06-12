package com.petrov.airport.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
public class State {
    private Integer id;
    private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        State state = (State) o;
        return Objects.equals(id, state.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
