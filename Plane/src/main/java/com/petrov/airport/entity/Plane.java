package com.petrov.airport.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Plane extends Essence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ToString.Exclude
    private Boolean removed;
    @Column(name = "airline_id")
    private Integer airlineId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Plane plane = (Plane) o;
        return Objects.equals(id, plane.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
