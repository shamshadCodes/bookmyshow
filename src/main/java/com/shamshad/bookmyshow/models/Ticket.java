package com.shamshad.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseClass{
    private int ticketPrice;
    private Date bookingTime;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    @OneToMany
    private List<ShowSeat> showSeats; //TODO: check if we really need showSeats list in Ticket class
    @ManyToOne
    private User bookedBy;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<Payment> payments;
}
