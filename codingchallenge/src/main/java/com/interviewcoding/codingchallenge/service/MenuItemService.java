package com.interviewcoding.codingchallenge.service;

import com.interviewcoding.codingchallenge.model.MenuItem;
import com.interviewcoding.codingchallenge.repositories.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;


    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public List<MenuItem> getMenuItems() {
        return menuItemRepository.findAll();
    }
}
