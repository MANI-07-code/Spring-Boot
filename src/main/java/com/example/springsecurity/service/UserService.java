package com.example.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springsecurity.entity.Users;
import com.example.springsecurity.repo.UserRepo;

@Service 
public class UserService {
    @Autowired 
    private UserRepo userRepo;

    @Autowired 
    private AuthenticationManager authManager;

    @Autowired 
    private JwtService jwtService;



    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public String register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "successfully added";
    }
    public String verifyUser(Users user) {
      Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));

      if(authentication.isAuthenticated()){
        return jwtService.generateToken(user.getName());
      }

      return "";

    }
}
