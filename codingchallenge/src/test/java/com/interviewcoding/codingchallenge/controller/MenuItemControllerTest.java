package com.interviewcoding.codingchallenge.controller;

import com.interviewcoding.codingchallenge.model.MenuItem;
import com.interviewcoding.codingchallenge.service.MenuItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MenuItemController.class)
public class MenuItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MenuItemService menuItemService;

    @Test
    public void testGetMenuItems() throws Exception{
        MenuItem item1 = new MenuItem();
        item1.setName("Salad");
        item1.setCategory(MenuItem.Category.APPETIZER);

        when(menuItemService.getMenuItems()).thenReturn(List.of(item1));

        mockMvc.perform(Array.get("/api/menu-items"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'name' : 'Salad'}]")));

    }
}