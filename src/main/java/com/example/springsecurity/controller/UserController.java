package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class UserController {

    @GetMapping ("/user")
    public String getUser(){
        return "get user";
    }
    
}
