package com.example.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecurity.entity.Users;

@Repository 
public interface UserRepo extends JpaRepository<Users,Integer>{
    
    Users findByName(String name);
}
