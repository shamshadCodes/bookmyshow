package com.shamshad.bookmyshow.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseClass{
    private Show show;
    private Seat seat;
    private ShowSeatStatus showSeatStatus;
}
