package com.example.userservice.controller.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserRequest {
    String name;
    String email;
    String username;
    String password;
}
