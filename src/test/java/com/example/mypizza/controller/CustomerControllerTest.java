package com.example.mypizza.controller;

import com.example.mypizza.dto.CustomerDto;
import com.example.mypizza.model.Customer;
import com.example.mypizza.service.util.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

        List<CustomerDto> customerDtoList = new ArrayList<>();
        when(customerService.getCustomerList()).thenReturn(customerDtoList);

        List<CustomerDto> result = customerController.getCustomerList();

        assertEquals(customerDtoList, result);
    }

    @Test
    void getCustomerByName() {
        String customerName = "John Doe";
        CustomerDto customerDto = new CustomerDto();
        when(customerService.getCustomerByName(customerName)).thenReturn(customerDto);

        CustomerDto result = customerController.getCustomerByName(customerName);

        assertEquals(customerDto, result);
    }

    @Test
    void addCustomer() {
        CustomerDto customerDto = new CustomerDto();
        when(customerService.addCustomer(customerDto)).thenReturn(customerDto);

        CustomerDto result = customerController.addCustomer(customerDto);

        assertEquals(customerDto, result);
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
        CustomerDto customerDto = new CustomerDto();
        when(customerService.updateCustomer(customerDto, customerId)).thenReturn(customerDto);

        CustomerDto result = customerController.updateCustomer(customerId, customerDto);

        assertEquals(customerDto, result);
    }
}

