package com.interviewcoding.codingchallenge.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


    private String name;

    @Min(value= 0, message = "Menu item price must be positive")
    private Double price;

    private Integer availableQuantity;

    @Enumerated(EnumType.STRING)
    private Category category;

    public enum Category{
        APPETIZER,
        MAIN_COURSE,
        DESSERT
    }

}
// MenuItem:
//- id (Long)
//- name (String)
//- price (Double)
//- availableQuantity (Integer)
//- category (Enum: APPETIZER, MAIN_COURSE, DESSERT)