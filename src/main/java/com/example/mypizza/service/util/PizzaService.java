package com.example.mypizza.service.util;

import com.example.mypizza.dto.PizzaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PizzaService {

    List<PizzaDto> getPizzaList();

    PizzaDto getPizzaByName(String name);

    PizzaDto addPizza(PizzaDto pizzaDto);

    void deletePizzaById(String id);

    PizzaDto updatePizza(PizzaDto pizzaDto, String id);
}
