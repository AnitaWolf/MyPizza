package com.example.mypizza.mapper;

import com.example.mypizza.dto.CustomerDto;
import com.example.mypizza.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(Customer customer);
    Customer toEntity(CustomerDto customerDto);

}
