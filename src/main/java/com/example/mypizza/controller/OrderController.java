package com.example.mypizza.controller;

import com.example.mypizza.model.Order;
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
     * Get a list of all orders.
     *
     * @return List of OrderDto containing order information
     */

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    /**
     * Get an order by its ID.
     *
     * @param id ID of the order to retrieve
     * @return Order containing order information
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    /**
     * Create a new order.
     *
     * @param order The order details to create
     * @return Order containing created order information
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
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
     * Updates an existing order.
     *
     * @param order The updated order information.
     * @return The updated order.
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }
}
