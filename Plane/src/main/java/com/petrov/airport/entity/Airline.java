package com.petrov.airport.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "plane")
public class Airline extends Essence {
    @Id
    @Setter(AccessLevel.NONE)
    @Column(name = "airline_id")
    private Integer id;
    @Transient
    private String title;
    @Transient
    private Double rating;
    @Transient
    @ToString.Exclude
    private Boolean removed;
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "airline_id")
    private List<Plane> planes;

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
