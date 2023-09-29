package com.example.mypizza.service.util;



import com.example.mypizza.model.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PizzaService {

    List<Pizza> getPizzaList();
    Pizza findPizzaById(String id);

    Pizza getPizzaByName(String name);

    Pizza addPizza(Pizza pizza);

    void deletePizzaById(String id);

    Pizza updatePizza(Pizza pizza, String id);

    List<Pizza> findAllByCafeId(String cafeId);



}
