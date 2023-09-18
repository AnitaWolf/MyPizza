package com.example.mypizza.controller;

import com.example.mypizza.dto.CustomerDto;
import com.example.mypizza.service.util.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling customer-related operations.

 */
@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    /**
     * Get a list of all customers.
     *
     * @return List of CustomerDto containing customer information
     */
    @GetMapping
    public List<CustomerDto> getCustomerList() {
        return customerService.getCustomerList();
    }

    /**
     * Get a customer by their name.
     *
     * @param name Name of the customer to retrieve
     * @return CustomerDto containing customer information
     */
    @GetMapping("/byName/{name}")
    public CustomerDto getCustomerByName(@PathVariable String name) {
        return customerService.getCustomerByName(name);
    }

    /**
     * Create a new customer.
     *
     * @param customerDto The customer details to create
     * @return CustomerDto containing created customer information
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto addCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.addCustomer(customerDto);
    }

    /**
     * Delete a customer by their ID.
     *
     * @param id ID of the customer to delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomerById(@PathVariable String id) {
        customerService.deleteCustomerById(id);
    }

    /**
     * Update a customer by their ID.
     *
     * @param id ID of the customer to update
     * @param customerDto The updated customer details
     * @return CustomerDto containing updated customer information
     */
    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable String id, @RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerDto, id);
    }
}
