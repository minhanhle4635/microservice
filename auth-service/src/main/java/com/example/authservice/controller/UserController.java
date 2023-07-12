package com.example.authservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/authorized")
public class UserController {
    @GetMapping("/admin")
    public ResponseEntity admin(){
        return ResponseEntity.ok("Welcome admin");
    }
    @GetMapping("/user")
    public ResponseEntity user(){
        return ResponseEntity.ok("Welcome user");
    }
}
