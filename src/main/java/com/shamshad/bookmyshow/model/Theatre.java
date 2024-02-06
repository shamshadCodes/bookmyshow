package com.shamshad.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theatre extends BaseClass{
    private String name;
    private String address;

    @OneToMany
    private List<Auditorium> auditoriums;
    @ManyToOne
    private City city;
}
