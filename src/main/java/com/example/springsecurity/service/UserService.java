package com.example.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springsecurity.entity.Users;
import com.example.springsecurity.repo.UserRepo;

@Service 
public class UserService {
    @Autowired 
    private UserRepo userRepo;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public String register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "successfully added";
    }
}
