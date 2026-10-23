package com.example.springsecurity.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecurity.entity.UserPrincipal;
import com.example.springsecurity.entity.Users;
import com.example.springsecurity.repo.UserRepo;



@Service 
public class MyUserDetailService implements UserDetailsService{

    @Autowired 
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        // throw new UnsupportedOperationException("Not supported yet.");
        Users user = repo.findByName(name);
        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }

        return new UserPrincipal(user);                                 

    }
    
}
