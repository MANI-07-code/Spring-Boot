package com.example.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
@EnableWebSecurity 
public class SecurityConfig {

    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       http.csrf(customizer -> customizer.disable());
       http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
       //http.formLogin(Customizer.withDefaults()); // for browser
       http.httpBasic(Customizer.withDefaults());
       http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

       //csrf config
    //    Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>(){     // Customizer is a interface
    //     @Override 
    //     public void customize(CsrfConfigurer<HttpSecurity> config){
    //         config.disable();                                              
    //     }
    //    };
    //    http.csrf(custCsrf);

        return http.build();
    }
    
}
