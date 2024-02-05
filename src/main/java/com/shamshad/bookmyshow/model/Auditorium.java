package com.shamshad.bookmyshow.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseClass{
    private String name;
    private List<List<Seat>> seats;
    private List<MoviePrint> moviePrints;
}
