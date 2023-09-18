package com.example.mypizza.repository;

import com.example.mypizza.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza,String> {

    Optional<Pizza> findPizzaById(String id);
    void deletePizzaById(String id);

    Optional<Pizza> findPizzasByName(String name);

}
