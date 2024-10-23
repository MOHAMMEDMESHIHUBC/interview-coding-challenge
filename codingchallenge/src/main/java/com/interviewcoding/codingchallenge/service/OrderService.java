package com.interviewcoding.codingchallenge.service;

import com.interviewcoding.codingchallenge.exceptions.ResourceNotFoundException;
import com.interviewcoding.codingchallenge.model.MenuItem;
import com.interviewcoding.codingchallenge.model.Order;
import com.interviewcoding.codingchallenge.model.OrderItem;
import com.interviewcoding.codingchallenge.repositories.MenuItemRepository;
import com.interviewcoding.codingchallenge.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;

    private final MenuItemRepository menuItemRepository;

    public OrderService(OrderRepository orderRepository, MenuItemRepository menuItemRepository) {
        this.orderRepository = orderRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Transactional
    public Order createOrder(Order order) throws BadRequestException {

        logger.info("Creating order for customer: {}", order.getCustomerName());


        if(order.getItems() == null || order.getItems().isEmpty()){
            throw new BadRequestException("Order must have at least one item");
        }
         double totalAmount = 0.0;
         for (OrderItem orderItem : order.getItems()){
             MenuItem menuItem = menuItemRepository
                     .findById(orderItem.getMenuItem().getId())
                     .orElseThrow(() -> new ResourceNotFoundException
                             ("MenuItem not found wiyh ID: "
                                     + orderItem.getMenuItem().getId()));
             if(menuItem.getAvailableQuantity()< orderItem.getQuantity()){
                 throw new BadRequestException("Insufficient quantity for menu Item: "
                         + menuItem.getName());
             }

             menuItem.setAvailableQuantity(menuItem.getAvailableQuantity()- orderItem.getQuantity());
             menuItemRepository.save(menuItem);

             orderItem.setMenuItem(menuItem);
             orderItem.setSubTotal(menuItem.getPrice()* orderItem.getQuantity());
             totalAmount += orderItem.getSubTotal();

             order.setTotalAmount(totalAmount);

             order.setStatus(Order.Status.RECEIVED);

             order.setCreatedAt(LocalDateTime.now());

         }

         logger.debug("Order created with total amount: {}", order.getTotalAmount());
        return orderRepository.save(order);
    }

    public Order getOrderByID(Long id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: "+ id));

    }
}





















