package com.shamshad.bookmyshow.model;

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
    private long id; //TODO: change this to UUID later
    private Date createdAt;
    private Date lastModifiedAt;
}
