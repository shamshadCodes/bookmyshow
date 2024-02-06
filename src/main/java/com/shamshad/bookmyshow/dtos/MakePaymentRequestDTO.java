package com.shamshad.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MakePaymentRequestDTO {
    private String showId;
    private String userId;
    private String seatId;
}
