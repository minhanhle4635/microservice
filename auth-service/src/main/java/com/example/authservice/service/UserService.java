package com.example.authservice.service;

import com.example.authservice.controller.dto.response.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUser();

    UserDTO getUser(Long id);
}
