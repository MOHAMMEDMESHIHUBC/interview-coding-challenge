package com.interviewcoding.codingchallenge.repositories;

import com.interviewcoding.codingchallenge.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
