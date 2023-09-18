package com.example.mypizza.mapper;

import com.example.mypizza.dto.OrderDto;
import com.example.mypizza.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toDto(Order order);

    Order toEntity(OrderDto dto);
}
