package com.example.authservice.controller;

import com.example.authservice.controller.dto.request.CreateUserRequest;
import com.example.authservice.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity register(@RequestBody CreateUserRequest request){
        authService.register(request);
        return ResponseEntity.ok("Created Successfully");
    }


}
