package com.example.mypizza.mapper;


import com.example.mypizza.dto.PizzaDto;
import com.example.mypizza.model.Pizza;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PizzaMapper {

    PizzaDto toDTO(Pizza pizza);
    Pizza toEntity(PizzaDto pizzaDto);
}
