package com.example.mypizza.repository;

import com.example.mypizza.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza, String> {

    Optional<Pizza> findPizzaById(String id);
    @Query("SELECT a FROM Pizza a WHERE a.cafe.id = :cafeId")
    List<Pizza> findAllByCafeId(@Param("cafeId") String cafeId);

    @Query("SELECT a FROM Pizza a WHERE a.name = :pizzaName")
    Pizza findPizzaByName(@Param("pizzaName") String pizzaName);



}
