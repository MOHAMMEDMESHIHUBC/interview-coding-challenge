package com.interviewcoding.codingchallenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Customer phone number is required")
    private String customerPhone;

    private LocalDateTime createdAt;

    private Double totalAmount;

    public enum Status {
        RECEIVED, PREPARING, READY, DELIVERED
    }

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(cascade = CascadeType.ALL)
    List<OrderItem> items;

}
// id (Long)
//- items (List<OrderItem>)
//- totalAmount (Double)
//- status (Enum: RECEIVED, PREPARING, READY, DELIVERED)
//- customerName (String)
//- customerPhone (String)
//- createdAt (LocalDateTime)