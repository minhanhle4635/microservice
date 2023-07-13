package com.example.authservice.service.impl;

import com.example.authservice.controller.dto.request.CreateUserRequest;
import com.example.authservice.controller.dto.response.AuthenticationResponse;
import com.example.authservice.entity.Enum.Role;
import com.example.authservice.entity.User;
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
    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse register(CreateUserRequest request) {
        User u = new User();
        u.setEmail(request.getEmail());
        u.setUsername(request.getUsername());
        u.setPassword(passwordEncoder.encode(request.getPassword()));
        u.getRoles().add(Role.USER);
        log.info("Register user: {}", u.getUsername());
        userRepository.save(u);
        String jwtToken = jwtService.generateToken(u);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
