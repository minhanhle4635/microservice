package com.example.authservice.service.impl;

import com.example.authservice.common.constant.ErrorCode;
import com.example.authservice.common.constant.ErrorMessage;
import com.example.authservice.controller.dto.response.UserDTO;
import com.example.authservice.entity.User;
import com.example.authservice.exception.BusinessException;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.service.UserService;
import com.example.authservice.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND, ErrorMessage.USER_NOT_FOUND));
        return userMapper.mapToDTO(user);
    }
}
