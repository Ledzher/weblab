package com.example.websitelab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends BaseEntity{
    @Column(name = "admin_name")
    private String adminName;
    @Column(name = "password")
    private String password;

    public void setRoles(List<Role> roles) {
    }
}
