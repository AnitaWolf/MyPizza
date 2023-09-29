package com.example.mypizza.service.impl;

import com.example.mypizza.model.Order;
import com.example.mypizza.repository.OrderRepository;
import com.example.mypizza.service.exeption.ErrorMessage;
import com.example.mypizza.service.exeption.OrderNotFoundException;
import com.example.mypizza.service.util.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


/**
 * Implementation of the OrderService interface for handling order-related operations.
 */
@RequiredArgsConstructor
@Component
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    /**
     * Gets a list of all orders.
     *
     * @return List of Order containing order information
     */
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Gets an order by its ID.
     *
     * @param id ID of the order to retrieve
     * @return Order containing order information
     * @throws OrderNotFoundException if the order with the given ID is not found
     */
    @Override
    public Order getOrderById(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException(ErrorMessage.ORDER_NOT_FOUND));
    }

    /**
     * Adds a new order.
     *
     * @param order The order details to create
     * @return Order containing created order information
     */
    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
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
            throw new OrderNotFoundException(ErrorMessage.ORDER_NOT_FOUND);
        }
    }

    public Order updateOrder(Order order) {
        if (!orderRepository.existsById(order.getId())) {
            throw new OrderNotFoundException(ErrorMessage.ORDER_NOT_FOUND);
        }
        return orderRepository.save(order);
    }

}
