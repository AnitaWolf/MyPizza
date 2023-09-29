package com.example.mypizza.repository;

import com.example.mypizza.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {


    Optional<Customer> findCustomerById(String id);

    @Query("SELECT a FROM Customer a WHERE a.name = :customerName")
    Optional<Customer> findCustomerByName(@Param("customerName") String customerName);

}
