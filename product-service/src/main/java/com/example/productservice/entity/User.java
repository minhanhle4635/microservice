package com.example.productservice.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @Column
    Long id;
    @Column
    LocalDateTime createdDate;
    @Column
    LocalDateTime updatedDate;
    @Column
    boolean active;
    @Column
    String name;
    @Column
    Integer age;
    @Column
    String phone;
    @Column
    String email;

    public User(Long id, LocalDateTime createdDate, LocalDateTime updatedDate, boolean active, String name, Integer age, String phone, String email) {
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.active = active;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public User() {
    }
}
