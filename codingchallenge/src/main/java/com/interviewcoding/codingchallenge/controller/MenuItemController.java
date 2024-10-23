package com.interviewcoding.codingchallenge.controller;

import com.interviewcoding.codingchallenge.model.MenuItem;
import com.interviewcoding.codingchallenge.service.MenuItemService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {

    private static final Logger logger = LoggerFactory.getLogger(MenuItemController.class);

    private final MenuItemService menuItemService;


    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping
    public ResponseEntity<MenuItem> addMenuItem(@Valid @RequestBody MenuItem menuItem) {
        logger.info("Adding new menu Item: {}", menuItem.getName());
        MenuItem createdMenuItem = menuItemService.addMenuItem(menuItem);
        return ResponseEntity.ok(createdMenuItem);
    }

    @GetMapping
    public ResponseEntity<List<MenuItem>> getMenuItems(){
        List<MenuItem> menuItems = menuItemService.getMenuItems();
        return ResponseEntity.ok(menuItems);
    }
}
