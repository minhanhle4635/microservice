package com.example.userservice.controller;

import com.example.userservice.controller.dto.message.SyncUserMessage;
import com.example.userservice.controller.dto.request.CreateUserRequest;
import com.example.userservice.controller.dto.request.LoginRequest;
import com.example.userservice.controller.dto.response.AuthenticationResponse;
import com.example.userservice.entity.Account;
import com.example.userservice.repository.AccountRepository;
import com.example.userservice.service.JwtService;
import com.example.userservice.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final AuthenticationManager authenticationManager;

    private final AccountRepository accountRepository;

    private final JwtService jwtService;

    KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> register(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        Account account = accountRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        String jwtToken = jwtService.generateToken(account);
        return ResponseEntity.ok(AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build());
    }

}
