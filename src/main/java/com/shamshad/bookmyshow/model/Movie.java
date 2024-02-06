package com.shamshad.bookmyshow.model;

import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Language> languages;
    @ElementCollection
    private List<String> Actors;//TODO: Add a actors class
}
