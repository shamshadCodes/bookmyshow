package com.shamshad.bookmyshow.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeatType extends BaseClass{
    private Show show;
    private SeatType seatType;
    private int price;
}
