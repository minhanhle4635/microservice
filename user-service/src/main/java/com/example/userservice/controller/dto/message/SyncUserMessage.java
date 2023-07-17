package com.example.userservice.controller.dto.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class SyncUserMessage {
    Long id;
    LocalDateTime createdDate;
    LocalDateTime updatedDate;
    boolean active;
    String name;
    String phone;
    Integer age;
    String email;

    public SyncUserMessage(Long id,
                           LocalDateTime createdDate,
                           LocalDateTime updatedDate,
                           boolean active,
                           String name,
                           String phone,
                           Integer age,
                           String email
    ) {
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.active = active;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }
}
