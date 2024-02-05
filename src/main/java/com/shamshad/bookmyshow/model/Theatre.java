package com.shamshad.bookmyshow.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theatre extends BaseClass{
    private String name;
    private String address;
    private List<Auditorium> auditoriums;
    private City city;
}
