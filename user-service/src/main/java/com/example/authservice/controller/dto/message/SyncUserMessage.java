package com.example.authservice.controller.dto.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
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
