package com.example.mypizza.repository;

import com.example.mypizza.model.Cafe;
import com.example.mypizza.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface CafeRepository extends JpaRepository<Cafe, String> {


    Optional<Cafe> findCafeById(String id);
    @Query("SELECT p.cafe FROM Pizza p WHERE p.name = :pizzaName")
    Cafe findCafeByPizzaName(@Param("pizzaName") String pizzaName);
    @Query("SELECT a FROM Pizza a WHERE a.cafe.name=:cafeName")
    List<Pizza> findAllPizzaByCafeName(@Param("cafeName") String cafeName);
}
