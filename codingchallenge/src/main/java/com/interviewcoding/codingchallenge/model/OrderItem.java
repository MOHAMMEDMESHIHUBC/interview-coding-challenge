package com.interviewcoding.codingchallenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
public class OrderItem {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private MenuItem menuItem;

    @Min(value = 1, message = "Order must have at least one item")
    private Integer quantity;

    private Double subTotal;



}
//OrderItem:
//- menuItem (MenuItem)
//- quantity (Integer)
//- subtotal (Double)