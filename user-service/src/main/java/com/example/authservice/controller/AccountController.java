package com.example.authservice.controller;

import com.example.authservice.controller.dto.response.UserDTO;
import com.example.authservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    @GetMapping("/admin")
    public ResponseEntity<String> admin(){
        return ResponseEntity.ok("Welcome admin");
    }
    @GetMapping("/user")
    public ResponseEntity<String> user(){
        return ResponseEntity.ok("Welcome user");
    }
    @GetMapping("/account/all")
    public ResponseEntity<List<UserDTO>> allAccount(){
        return ResponseEntity.ok(accountService.getAllUser());
    }
    @GetMapping("/account/{id}")
    public ResponseEntity<UserDTO> getAccount(@PathVariable Long id){
        return ResponseEntity.ok(accountService.getUser(id));
    }
}
