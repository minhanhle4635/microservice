package com.example.productservice.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends Auditing{
    @Column
    String name;

    @Column
    String description;

    public Product(){}

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
