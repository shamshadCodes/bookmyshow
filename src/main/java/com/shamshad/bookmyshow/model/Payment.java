package com.shamshad.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Payment extends BaseClass{
    private int amount;
    private String referenceId;
    private Date paymentTime;

    @Enumerated(EnumType.STRING)
    private PaymentGateway paymentGateway;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
}
