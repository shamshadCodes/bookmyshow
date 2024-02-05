package com.shamshad.bookmyshow.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat extends BaseClass{
    private Show show;
    private Seat seat;
    private ShowSeatStatus showSeatStatus;
}
