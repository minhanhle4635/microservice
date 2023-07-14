package com.example.authservice.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends Auditing{
    String name;
    String age;
    String phone;
    String email;
}
