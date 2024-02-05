package com.shamshad.bookmyshow.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseClass{
    private String name;
    private Date releaseDate;
    private List<Language> languages;
    private List<String> Actors;//TODO: Add a actors class
}
