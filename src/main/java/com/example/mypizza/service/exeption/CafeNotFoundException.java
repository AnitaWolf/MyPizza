package com.example.mypizza.service.exeption;

public class CafeNotFoundException extends RuntimeException{

    public CafeNotFoundException(String message){
        super(message);
    }
}
