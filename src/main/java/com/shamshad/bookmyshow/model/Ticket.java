package com.shamshad.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseClass{
//    private int price; //TODO Check if we need price here
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
