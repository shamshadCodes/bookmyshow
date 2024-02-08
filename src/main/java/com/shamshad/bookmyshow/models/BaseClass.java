package com.shamshad.bookmyshow.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; //TODO: change this to UUID later
    private Date createdAt;
    private Date lastModifiedAt;
}
