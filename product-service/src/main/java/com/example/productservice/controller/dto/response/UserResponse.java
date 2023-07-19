package com.example.productservice.controller.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    boolean active;
    String name;
    String phone;
    Integer age;
    String email;
}
