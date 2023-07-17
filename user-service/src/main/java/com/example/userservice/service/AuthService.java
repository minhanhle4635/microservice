package com.example.userservice.service;

import com.example.userservice.controller.dto.request.CreateUserRequest;
import com.example.userservice.controller.dto.response.AuthenticationResponse;

public interface AuthService {
    AuthenticationResponse register(CreateUserRequest request);
}
