package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController 
public class UserController {

    @GetMapping ("/user")
    public String getUser(HttpServletRequest request){
        return "get user "+request.getSession().getId();
    }
    
}
