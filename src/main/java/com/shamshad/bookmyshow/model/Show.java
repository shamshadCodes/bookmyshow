package com.shamshad.bookmyshow.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Show extends BaseClass{
    private Movie movie;
    private Auditorium auditorium;
    private Date startTime;
    private Date endTime;
    private Language language;
    private MoviePrint moviePrint;
}
