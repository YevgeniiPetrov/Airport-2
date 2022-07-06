package com.petrov.airport.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    private Integer id;
    private LocalDateTime departure;
    private LocalTime duration;
    private Route route;
    private State state;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
