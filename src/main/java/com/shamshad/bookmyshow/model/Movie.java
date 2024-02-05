package com.shamshad.bookmyshow.model;

import java.util.Date;
import java.util.List;

public class Movie extends BaseClass{
    private String name;
    private Date releaseDate;
    private List<Language> languages;
    private List<String> Actors;//TODO: Add a actors class
}
