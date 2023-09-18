package com.example.mypizza.repository;

import com.example.mypizza.model.Order;
import com.example.mypizza.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,String> {




    void deleteById(String id);

    Optional<Order> findById(String id);
}
