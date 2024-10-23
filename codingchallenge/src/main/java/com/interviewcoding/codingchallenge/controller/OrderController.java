package com.interviewcoding.codingchallenge.controller;

import com.interviewcoding.codingchallenge.model.MenuItem;
import com.interviewcoding.codingchallenge.model.Order;
import com.interviewcoding.codingchallenge.service.OrderService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) throws BadRequestException {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id){
        Order order = orderService.getOrderByID(id);
        return ResponseEntity.ok(order);
    }
}
