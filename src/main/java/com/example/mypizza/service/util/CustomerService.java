package com.example.mypizza.service.util;


import com.example.mypizza.model.Customer;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CustomerService {

    List<Customer> getCustomerList();

    Customer getCustomerByName(String name);

    Customer addCustomer(Customer customer);

    void deleteCustomerById(String id);

    Customer updateCustomer(Customer Customer, String id);

}
