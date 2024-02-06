package com.shamshad.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeatType extends BaseClass{
    private int price;

    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
}
