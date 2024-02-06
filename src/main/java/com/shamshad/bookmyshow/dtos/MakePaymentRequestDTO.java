package com.shamshad.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MakePaymentRequestDTO {
    private Long showId;
    private Long userId;
    private List<Long> seats;
}
