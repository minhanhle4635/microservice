package com.example.authservice.service;

import com.example.authservice.controller.dto.request.CreateUserRequest;

public interface AuthService {
    void register(CreateUserRequest request);
}
