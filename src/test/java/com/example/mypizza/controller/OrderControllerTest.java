package com.example.mypizza.controller;


import com.example.mypizza.model.Order;
import com.example.mypizza.service.util.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderControllerTest {


    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    public OrderControllerTest(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addOrder() {
        Order orderDto = new Order();  // Create a sample OrderDto
        when(orderService.addOrder(orderDto)).thenReturn(orderDto);

        Order result = orderController.addOrder(orderDto);

        assertEquals(orderDto, result);
        verify(orderService, times(1)).addOrder(orderDto);
    }

    @Test
    void deleteOrderById() {
        String orderId = "123";
        doNothing().when(orderService).deleteOrderById(orderId);

        orderController.deleteOrderById(orderId);

        verify(orderService, times(1)).deleteOrderById(orderId);
    }

    @Test
    void getOrderById() {
        String orderId = "123";
        Order orderDto = new Order();  // Create a sample OrderDto
        when(orderService.getOrderById(orderId)).thenReturn(orderDto);

        Order result = orderController.getOrderById(orderId);

        assertEquals(orderDto, result);
        verify(orderService, times(1)).getOrderById(orderId);
    }

    @Test
    void getAllOrders() {
        List<Order> orderDtoList = new ArrayList<>();  // Create a sample list of OrderDto
        when(orderService.getAllOrders()).thenReturn(orderDtoList);

        List<Order> result = orderController.getAllOrders();

        assertEquals(orderDtoList, result);
        verify(orderService, times(1)).getAllOrders();
    }
}
