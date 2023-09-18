package com.example.mypizza.service.impl;

import com.example.mypizza.dto.CustomerDto;
import com.example.mypizza.mapper.CustomerMapper;
import com.example.mypizza.model.Customer;
import com.example.mypizza.repository.CustomerRepository;
import com.example.mypizza.service.exeption.CustomerNotFoundException;
import com.example.mypizza.service.exeption.ErrorMessage;
import com.example.mypizza.service.util.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Implementation of the CustomerService interface for handling customer-related operations.
 */
@RequiredArgsConstructor
@Component
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    /**
     * Get a list of all customers.
     *
     * @return List of CustomerDto containing customer information
     */
    @Override
    public List<CustomerDto> getCustomerList() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Get a customer by their name.
     *
     * @param customerName Name of the customer to retrieve
     * @return CustomerDto containing customer information
     * @throws CustomerNotFoundException if the customer with the given name is not found
     */
    @Override
    public CustomerDto getCustomerByName(String customerName) {
        Optional<Customer> customerOptional = customerRepository.findByName(customerName);
        return customerOptional.map(customerMapper::toDto).orElseThrow(() ->
                new CustomerNotFoundException(ErrorMessage.CUSTOMER_NOT_FOUND));
    }

    /**
     * Add a new customer.
     *
     * @param customerDto The customer details to create
     * @return CustomerDto containing created customer information
     */
    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        return customerMapper.toDto(customer);
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
     * @param customerDto The updated customer details
     * @param id ID of the customer to update
     * @return CustomerDto containing updated customer information
     * @throws CustomerNotFoundException if the customer with the given ID is not found
     */
    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, String id) {
        Optional<Customer> existingCustomer = customerRepository.findCustomerById(id);
        Customer customer = customerMapper.toEntity(customerDto);
        if (existingCustomer.isPresent()) {
            customerDto.setId(id);
            return customerMapper.toDto(customerRepository.save(customer));
        } else {
            throw new CustomerNotFoundException(ErrorMessage.ID_NOT_FOUND);
        }
    }
}
