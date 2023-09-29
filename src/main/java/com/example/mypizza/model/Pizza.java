package com.example.mypizza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "cafe_id", referencedColumnName = "id")
    private Cafe cafe;

    @JsonIgnore
    @ManyToMany(mappedBy = "pizzas")
    List<Order> orderList;


}

