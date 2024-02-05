package com.shamshad.bookmyshow.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User extends BaseClass{
    private String name;
    private String password;
    private String email;
    private Date dateOfBirth;
}
