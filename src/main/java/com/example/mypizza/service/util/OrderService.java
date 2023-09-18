package com.example.mypizza.service.util;

import com.example.mypizza.dto.OrderDto;
import com.example.mypizza.model.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderService {

    OrderDto addOrder(OrderDto orderDto);

    void deleteOrderById(String id);

    OrderDto getOrderById(String id);

    List<OrderDto> getAllOrders();

}
