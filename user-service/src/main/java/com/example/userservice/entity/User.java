package com.example.userservice.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Setter
@Getter
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
}
