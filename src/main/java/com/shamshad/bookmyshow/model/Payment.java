package com.shamshad.bookmyshow.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseClass{
    private String referenceId;
    private PaymentGateway paymentGateway;
    private int amount;
    private PaymentStatus paymentStatus;
}
