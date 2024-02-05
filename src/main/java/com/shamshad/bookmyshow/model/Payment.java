package com.shamshad.bookmyshow.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment extends BaseClass{
    private String referenceId;
    private PaymentGateway paymentGateway;
    private int amount;
    private PaymentStatus paymentStatus;
}
