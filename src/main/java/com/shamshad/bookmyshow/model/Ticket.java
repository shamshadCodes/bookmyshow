package com.shamshad.bookmyshow.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Ticket extends BaseClass{
    private Show show;
    private Date bookingTime;
    private List<Payment> payments;
}
