package com.example.mypizza.controller;

import com.example.mypizza.model.Customer;
import com.example.mypizza.service.util.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerControllerTest {
    @Mock
    private CustomerService customerService;
    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        customerController = new CustomerController(customerService);
    }

    @Test
    void getCustomerList() {

        List<Customer> customerList = new ArrayList<>();
        when(customerService.getCustomerList()).thenReturn(customerList);

        List<Customer> result = customerController.getAllCustomers();

        assertEquals(customerList, result);
    }

    @Test
    void getCustomerByName() {
        String customerName = "John Doe";
        Customer customer = new Customer();
        when(customerService.getCustomerByName(customerName)).thenReturn(customer);

        Customer result = customerController.getCustomerByName(customerName);

        assertEquals(customer, result);
    }

    @Test
    void addCustomer() {
        Customer customer = new Customer();
        when(customerService.addCustomer(customer)).thenReturn(customer);

        Customer result = customerController.createCustomer(customer);

        assertEquals(customer, result);
    }

    @Test
    void deleteCustomerById() {
        String customerId = "123";
        doNothing().when(customerService).deleteCustomerById(customerId);

        customerController.deleteCustomerById(customerId);
        verify(customerService, times(1)).deleteCustomerById(customerId);
    }

    @Test
    void updateCustomer() {
        String customerId = "123";
        Customer customer = new Customer();
        when(customerService.updateCustomer(customer, customerId)).thenReturn(customer);

        Customer result = customerController.updateCustomer(customerId, customer);

        assertEquals(customer, result);
    }
}

