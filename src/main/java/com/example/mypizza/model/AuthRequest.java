package com.example.mypizza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    //private String username;
    //private String password;
    private String email;
    private String password;
    private List<String> roles;

}
