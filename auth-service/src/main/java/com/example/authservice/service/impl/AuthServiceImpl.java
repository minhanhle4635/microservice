package com.example.authservice.service.impl;

import com.example.authservice.controller.dto.request.CreateUserRequest;
import com.example.authservice.entity.User;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public void register(CreateUserRequest request) {
        User u = new User();
        u.setEmail(request.getEmail());
        u.setUsername(request.getUsername());
        u.setPassword(request.getPassword());
        userRepository.save(u);
    }
}
