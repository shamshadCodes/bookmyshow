package com.shamshad.bookmyshow.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class City extends BaseClass{
    private String name;
    private List<Theatre> theatres;
    private String state;
}
