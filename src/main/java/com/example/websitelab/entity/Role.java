package com.example.websitelab.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    public Role(String roleAdmin) {
    }

    public Role() {

    }
}
