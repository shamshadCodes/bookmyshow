package com.shamshad.bookmyshow.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class User extends BaseClass{
    private String name;
    private String password;
    private String email;
    private Date dateOfBirth;
}
