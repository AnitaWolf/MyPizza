package com.example.mypizza.repository;

import com.example.mypizza.model.Order;
import com.example.mypizza.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {

    Optional<Order> findById(String id);

    @Modifying
    @Query("UPDATE Order o SET o.pizzas = :pizzas WHERE o.id = :orderId")
    void updateOrderPizzas(@Param("orderId") String orderId, @Param("pizzas") List<Pizza> pizzas);

    @Query("SELECT o.pizzas FROM Order o WHERE o.id = :orderId")
    List<Pizza> getPizzasByOrderId(@Param("orderId") String orderId);
}
