package com.example.mypizza.service.util;

import com.example.mypizza.dto.CustomerDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CustomerService {

    List<CustomerDto> getCustomerList();

    CustomerDto getCustomerByName(String name);

    CustomerDto addCustomer(CustomerDto customerDto);

    void deleteCustomerById(String id);

    CustomerDto updateCustomer(CustomerDto CustomerDto, String id);

}
