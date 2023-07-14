package com.example.authservice.service;

import com.example.authservice.controller.dto.response.UserDTO;

import java.util.List;

public interface AccountService {
    List<UserDTO> getAllUser();

    UserDTO getUser(Long id);
}
