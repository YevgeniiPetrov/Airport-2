package com.petrov.airport.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "passenger_flight")
public class Flight extends Essence {
    @Column(name = "flight_id")
    @Id
    @Setter(AccessLevel.NONE)
    private Integer id;
    @Transient
    @ToString.Exclude
    private Boolean removed;
    @Column(name = "terminal_id")
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "passenger_flight",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id")
    )
    private List<Passenger> passengers;

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
