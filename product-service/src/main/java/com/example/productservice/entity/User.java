package com.example.productservice.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends Auditing {
    @Column
    String name;
    @Column
    Integer age;
    @Column
    String phone;
    @Column
    String email;

    public User(String name, Integer age, String phone, String email) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }
}
