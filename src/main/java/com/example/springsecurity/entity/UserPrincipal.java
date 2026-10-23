package com.example.springsecurity.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails{
    private Users user;
   public UserPrincipal(Users user){
        this.user = user;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

       // throw new UnsupportedOperationException("Not supported yet.");

      // return Collections.singleton(new  SimpleGrantedAuthority("ADMIN"));
      return Collections.singleton(new SimpleGrantedAuthority("ADMIN") );
    }

    @Override
    public String getPassword() {
       // throw new UnsupportedOperationException("Not supported yet.");
       return user.getPassword();
    }

    @Override
    public String getUsername() {
        //throw new UnsupportedOperationException("Not supported yet.");
       return  user.getName();
    }
    
}
