package com.example.authservice.security;

import com.example.authservice.entity.Enum.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/auth").permitAll()
                .antMatchers("/admin").hasRole(Role.ADMIN.name())
                .antMatchers("/user").hasRole(Role.USER.name())
                .anyRequest().authenticated();
        return http.build();
    }
}
