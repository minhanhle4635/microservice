package com.example.userservice.service.impl;

import com.example.userservice.controller.dto.message.SyncUserMessage;
import com.example.userservice.controller.dto.request.CreateUserRequest;
import com.example.userservice.controller.dto.response.AuthenticationResponse;
import com.example.userservice.entity.Account;
import com.example.userservice.entity.Enum.Role;
import com.example.userservice.entity.User;
import com.example.userservice.event.UserDataEventProducer;
import com.example.userservice.repository.AccountRepository;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.AuthService;
import com.example.userservice.service.JwtService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserDataEventProducer userDataEventProducer;
    private void syncUserData(SyncUserMessage message) {
        userDataEventProducer.send(message);
    }

    @Override
    public AuthenticationResponse register(CreateUserRequest request) {
        //create new Account
        Account a = new Account();
        a.setUsername(request.getUsername());
        a.setPassword(passwordEncoder.encode(request.getPassword()));
        a.getRoles().add(Role.USER);
        log.info("Register user: {}", a.getUsername());

        //create new User
        User u = new User();
        u.setName(request.getName());
        u.setEmail(request.getEmail());
        User savedUser = userRepository.save(u);

        //save id user for account
        a.setUser(u);
        accountRepository.save(a);

        //send kafka
        SyncUserMessage message = new SyncUserMessage(
                savedUser.getId(),
                savedUser.getCreatedDate(),
                savedUser.getUpdatedDate(),
                savedUser.isActive(),
                savedUser.getName(),
                savedUser.getPhone(),
                savedUser.getAge(),
                savedUser.getEmail()
        );
        syncUserData(message);
        String jwtToken = jwtService.generateToken(a);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
