package com.shamshad.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseClass{
    private Date seatLockedAt;

    @Enumerated(EnumType.STRING) //TODO: Store in a different way than ORDINAL or STRING
    private ShowSeatStatus showSeatStatus;

    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
}
