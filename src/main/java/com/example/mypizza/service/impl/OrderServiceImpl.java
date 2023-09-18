package com.example.mypizza.service.impl;

import com.example.mypizza.dto.OrderDto;
import com.example.mypizza.mapper.OrderMapper;
import com.example.mypizza.model.Order;
import com.example.mypizza.model.Pizza;
import com.example.mypizza.repository.OrderRepository;
import com.example.mypizza.service.exeption.ErrorMessage;
import com.example.mypizza.service.exeption.OrderNotFoundException;
import com.example.mypizza.service.util.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the OrderService interface for handling order-related operations.
 */
@RequiredArgsConstructor
@Component
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    /**
     * Adds a new order.
     *
     * @param orderDto The order details to create
     * @return OrderDto containing created order information
     */
    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        orderRepository.save(order);
        return orderMapper.toDto(order);
    }

    /**
     * Deletes an order by its ID.
     *
     * @param id ID of the order to delete
     * @throws OrderNotFoundException if the order with the given ID is not found
     */
    @Override
    public void deleteOrderById(String id) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            orderRepository.deleteById(id);
        } else {
            throw new OrderNotFoundException("Order not found with ID: " + id);
        }
    }

    /**
     * Gets an order by its ID.
     *
     * @param id ID of the order to retrieve
     * @return OrderDto containing order information
     * @throws OrderNotFoundException if the order with the given ID is not found
     */
    @Override
    public OrderDto getOrderById(String id) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        return existingOrder.map(orderMapper::toDto)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + id));
    }

    /**
     * Gets a list of all orders.
     *
     * @return List of OrderDto containing order information
     */
    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

}
