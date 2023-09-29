package com.example.mypizza.service.util;


import com.example.mypizza.model.Order;
import com.example.mypizza.model.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderService {

    Order addOrder(Order orderDto);

    void deleteOrderById(String id);

    Order getOrderById(String id);

    List<Order> getAllOrders();
    Order updateOrder(Order order);



}
