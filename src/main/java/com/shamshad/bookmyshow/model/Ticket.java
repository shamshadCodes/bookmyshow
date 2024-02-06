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
    @ManyToOne
    private Show show;
    private Date bookingTime;
    @OneToMany
    private List<Payment> payments;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
}
