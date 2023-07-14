package com.example.authservice.service.impl;

import com.example.authservice.common.constant.ErrorCode;
import com.example.authservice.common.constant.ErrorMessage;
import com.example.authservice.controller.dto.response.UserDTO;
import com.example.authservice.entity.Account;
import com.example.authservice.exception.BusinessException;
import com.example.authservice.repository.AccountRepository;
import com.example.authservice.service.AccountService;
import com.example.authservice.service.mapper.AccountMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    @Override
    public List<UserDTO> getAllUser() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(accountMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND, ErrorMessage.USER_NOT_FOUND));
        return accountMapper.mapToDTO(account);
    }
}
