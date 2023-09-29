package com.example.mypizza.service.impl;


import com.example.mypizza.model.Customer;
import com.example.mypizza.repository.CustomerRepository;
import com.example.mypizza.service.exeption.CustomerNotFoundException;
import com.example.mypizza.service.exeption.ErrorMessage;
import com.example.mypizza.service.util.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


/**
 * Implementation of the CustomerService interface for handling customer-related operations.
 */
@RequiredArgsConstructor
@Component
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    /**
     * Get a list of all customers.
     *
     * @return List of CustomerDto containing customer information
     */
    @Override
    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    /**
     * Get a customer by their name.
     *
     * @param customerName Name of the customer to retrieve
     * @return CustomerDto containing customer information
     * @throws CustomerNotFoundException if the customer with the given name is not found
     */
    @Override
    public Customer getCustomerByName(String customerName) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByName(customerName);
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        } else
            throw new CustomerNotFoundException(ErrorMessage.CUSTOMER_NOT_FOUND);
    }

    /**
     * Add a new customer.
     *
     * @param customer The customer details to create
     * @return CustomerDto containing created customer information
     */
    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Delete a customer by their ID.
     *
     * @param id ID of the customer to delete
     * @throws CustomerNotFoundException if the customer with the given ID is not found
     */
    @Override
    public void deleteCustomerById(String id) {
        Optional<Customer> existingCustomer = customerRepository.findCustomerById(id);
        if (existingCustomer.isPresent()) {
            customerRepository.deleteById(id);
        } else {
            throw new CustomerNotFoundException(ErrorMessage.CUSTOMER_NOT_FOUND);
        }
    }

    /**
     * Update a customer by their ID.
     *
     * @param updatecustomer The updated customer details
     * @param id             ID of the customer to update
     * @return CustomerDto containing updated customer information
     * @throws CustomerNotFoundException if the customer with the given ID is not found
     */
    @Override
    public Customer updateCustomer(Customer updatecustomer, String id) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerById(id);

        if (optionalCustomer.isPresent()) {
            Customer existingcustomer = optionalCustomer.get();

            existingcustomer.setName(updatecustomer.getName());
            existingcustomer.setLocation(updatecustomer.getLocation());
            existingcustomer.setPhone(updatecustomer.getPhone());
            existingcustomer.setPassword(updatecustomer.getPassword());
            existingcustomer.setEmail(updatecustomer.getEmail());
            existingcustomer.setCreated(updatecustomer.getCreated());
            return customerRepository.save(existingcustomer);
        } else
            throw new CustomerNotFoundException(ErrorMessage.ID_NOT_FOUND);
    }
}
