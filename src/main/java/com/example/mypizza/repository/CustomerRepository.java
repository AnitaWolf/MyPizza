package com.example.mypizza.repository;

import com.example.mypizza.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,String> {


    Optional<Customer> findCustomerById(String id);

    void deleteById(String id);

    Optional<Customer> findByName(String name);
}
