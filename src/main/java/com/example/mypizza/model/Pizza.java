package com.example.mypizza.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pizza_data")
public class Pizza {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Column(name = "pizza_name")
    private String name;

    private String size;

    private double price;

    private String description;

    @Column(name = "created_at")
    private LocalDateTime created;

}

