package com.shamshad.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class City extends BaseClass{
    private String name;
    private String state;

    @OneToMany
    private List<Theatre> theatres;
}
