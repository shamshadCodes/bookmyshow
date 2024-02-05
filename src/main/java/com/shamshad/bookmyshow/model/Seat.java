package com.shamshad.bookmyshow.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseClass{
    private String name;
    private int row;
    private int col;
    private SeatType seatType;
}
