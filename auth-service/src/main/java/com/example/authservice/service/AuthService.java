package com.example.authservice.service;

import com.example.authservice.controller.dto.request.CreateUserRequest;
import com.example.authservice.controller.dto.response.AuthenticationResponse;

public interface AuthService {
    AuthenticationResponse register(CreateUserRequest request);
}
