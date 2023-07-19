package com.example.userservice.service;

import com.example.userservice.controller.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();
}
