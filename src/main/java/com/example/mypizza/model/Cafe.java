package com.example.mypizza.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;
import java.util.List;


import static jakarta.persistence.CascadeType.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cafe_data")
public class Cafe {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "cafe_name")
    private String name;

    private String location;

    private String phone;

    @Column(name = "created_at")
    private LocalDateTime created;

    @OneToMany(mappedBy = "cafe", fetch = FetchType.EAGER)
    private List<Pizza> pizzaList;

}