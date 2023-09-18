package com.example.mypizza.dto;


import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CafeDto {
   private String id;
   private String name;
   private String location;
   private String phone;
   private LocalDateTime created;
   private List<PizzaDto> pizzaList;
}
