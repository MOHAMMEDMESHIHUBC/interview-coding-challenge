package com.interviewcoding.codingchallenge.repositories;

import com.interviewcoding.codingchallenge.model.MenuItem;
import com.interviewcoding.codingchallenge.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
