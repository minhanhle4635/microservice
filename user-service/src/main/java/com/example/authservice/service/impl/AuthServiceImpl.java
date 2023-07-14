package com.example.authservice.service.impl;

import com.example.authservice.controller.dto.request.CreateUserRequest;
import com.example.authservice.controller.dto.response.AuthenticationResponse;
import com.example.authservice.entity.Account;
import com.example.authservice.entity.Enum.Role;
import com.example.authservice.entity.User;
import com.example.authservice.repository.AccountRepository;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.service.AuthService;
import com.example.authservice.service.JwtService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse register(CreateUserRequest request) {
        //create new Account
        Account a = new Account();
        a.setUsername(request.getUsername());
        a.setPassword(passwordEncoder.encode(request.getPassword()));
        a.getRoles().add(Role.USER);
        log.info("Register user: {}", a.getUsername());
        accountRepository.save(a);
        //create new User
        User u = new User();
        u.setName(request.getName());
        u.setEmail(request.getEmail());
        userRepository.save(u);
        String jwtToken = jwtService.generateToken(a);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
