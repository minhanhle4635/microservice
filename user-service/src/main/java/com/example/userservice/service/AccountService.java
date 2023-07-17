package com.example.userservice.service;

import com.example.userservice.controller.dto.response.UserDTO;

import java.util.List;

public interface AccountService {
    List<UserDTO> getAllUser();

    UserDTO getUser(Long id);
}
