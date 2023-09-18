package com.example.mypizza.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class PizzaDto {

    private String id;

    private String name;

    private String size;

    private double price;

    private String description;

    private LocalDateTime created;

}
