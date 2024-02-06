package com.shamshad.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MakePaymentResponseDTO {
    private int ticketPrice;
    private String theatreName;
    private String auditoriumName;
    private Date showStartTime;
    private List<String> seats;
    private String status;
    private String message;
}
