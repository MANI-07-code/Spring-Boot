package com.example.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.entity.Users;
import com.example.springsecurity.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController 
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping ("/user")
    public String getUser(HttpServletRequest request){
        return "get user "+request.getSession().getId();
    }

    @PostMapping("/register")
    public String postuser(@RequestBody Users user){
         
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
return userService.verifyUser(user);
    }
    
}
