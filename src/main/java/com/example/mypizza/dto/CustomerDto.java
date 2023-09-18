package com.example.mypizza.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CustomerDto {

    private String id;
    private String name;
    private String phone;
    private String email;
    private String location;
    private String password;
    private LocalDateTime created;
}
