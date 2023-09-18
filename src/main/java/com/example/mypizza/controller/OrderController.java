package com.example.mypizza.controller;

import com.example.mypizza.dto.OrderDto;
import com.example.mypizza.model.Pizza;
import com.example.mypizza.service.util.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller handling operations related to orders.
 */
@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /**
     * Create a new order.
     *
     * @param orderDto The order details to create
     * @return OrderDto containing created order information
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto addOrder(@RequestBody OrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }

    /**
     * Delete an order by its ID.
     *
     * @param id ID of the order to delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrderById(@PathVariable String id) {
        orderService.deleteOrderById(id);
    }

    /**
     * Get an order by its ID.
     *
     * @param id ID of the order to retrieve
     * @return OrderDto containing order information
     */
    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    /**
     * Get a list of all orders.
     *
     * @return List of OrderDto containing order information
     */
    @GetMapping
    public List<OrderDto> getAllOrders() {

        return orderService.getAllOrders();
    }

}
