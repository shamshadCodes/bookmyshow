package com.shamshad.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseClass{
    private String name;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<SupportedMoviePrints> moviePrints;

    @OneToMany
    private List<Seat> seats;
    @ManyToOne
    private Theatre theatre;
}
