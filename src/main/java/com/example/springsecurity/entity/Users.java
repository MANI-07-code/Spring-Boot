package com.example.springsecurity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class Users {
    @Id 
    private int id;
    private String name;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Users{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append('}');
        return sb.toString();
    }
    
}
