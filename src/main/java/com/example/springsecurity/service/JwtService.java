package com.example.springsecurity.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service 
public class JwtService {

      private  String secretKey="ertyuiokj";

      public JwtService(){
        try{
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();
               secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());

        }catch(NoSuchAlgorithmException exception){

            throw new RuntimeException(exception);
        }
      }

    public String generateToken(String name){

        Map<String,Object> claim = new HashMap<>();

        return Jwts.builder()
        .claims()
        .add(claim)
        .subject(name)
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis()+60*60*10))
        .and()
        .signWith(getKey())
        .compact();

      
    }

    private Key getKey() {
        byte[] bytes = Decoders.BASE64.decode(secretKey);
      
        return Keys.hmacShaKeyFor(bytes);

    }
    
}
