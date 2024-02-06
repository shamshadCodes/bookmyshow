package com.shamshad.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseClass{
    private String name;
    private int row;
    private int col;
    @ManyToOne
    private SeatType seatType;
}
