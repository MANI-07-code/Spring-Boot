package com.example.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
@EnableWebSecurity 
public class SecurityConfig {

    @Autowired 
    private UserDetailsService userDetailsService;

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

    // @Bean 
    // public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){

    //     UserDetails user1 =  User.builder()
        
    //     .username("maki")
    //     .password(passwordEncoder.encode("ma@123"))
    //     .roles("USER")
    //     .build();

    //     UserDetails user2 =  User.builder()
    
    //     .username("mahe")
    //     .password(passwordEncoder.encode("he@123"))
    //     .roles("ADMIN")
    //     .build();

    //     return new InMemoryUserDetailsManager(user1,user2);
    // }

      @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean 
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService,PasswordEncoder passwordEncoder){

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
    
}
