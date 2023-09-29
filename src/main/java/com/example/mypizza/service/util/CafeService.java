package com.example.mypizza.service.util;


import com.example.mypizza.model.Cafe;
import com.example.mypizza.model.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CafeService {

    List<Cafe> getCafeList();

    Cafe getCafeById(String id);

    Cafe addCafe(Cafe cafe);

    void deleteCafeById(String id);

    Cafe updateCafe(Cafe cafe, String id);

    Cafe findCafeByPizzaName(String pizzaName);
    List<Pizza> findPizzasByCafeName(String cafeName);
}
