package com.example.mypizza.dto;

import com.example.mypizza.model.Customer;
import com.example.mypizza.model.Pizza;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDto {

    private String id;

    private LocalDateTime created;

    private List<Pizza> pizzas;

    private Customer customer;

    private Pizza pizza;

}