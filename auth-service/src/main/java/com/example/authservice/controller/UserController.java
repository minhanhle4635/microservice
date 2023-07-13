package com.example.authservice.controller;

import com.example.authservice.controller.dto.response.UserDTO;
import com.example.authservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/home")
public class UserController {
    private final UserService userService;
    @GetMapping("/admin")
    public ResponseEntity<String> admin(){
        return ResponseEntity.ok("Welcome admin");
    }
    @GetMapping("/user")
    public ResponseEntity<String> user(){
        return ResponseEntity.ok("Welcome user");
    }
    @GetMapping("/user/all")
    public ResponseEntity<List<UserDTO>> allUsers(){
        return ResponseEntity.ok(userService.getAllUser());
    }
}
