package com.shamshad.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Show extends BaseClass{
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    private Date startTime;
    private Date endTime;
    @Enumerated(EnumType.STRING)
    private Language language;
    @Enumerated(EnumType.STRING)
    private SupportedMoviePrints moviePrint;
}
