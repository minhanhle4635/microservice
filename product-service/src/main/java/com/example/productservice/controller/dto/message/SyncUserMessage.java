package com.example.productservice.controller.dto.message;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SyncUserMessage {
    Long id;
    String name;
    String phone;
    Integer age;
    String email;

    public SyncUserMessage(Long id, String name, String phone, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }
}
