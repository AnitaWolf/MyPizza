package com.example.mypizza.repository;

import com.example.mypizza.model.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface CafeRepository extends JpaRepository<Cafe,String> {


    Optional<Cafe> findCafeById(String id);
   void deleteCafeById(String cafeId);
}
