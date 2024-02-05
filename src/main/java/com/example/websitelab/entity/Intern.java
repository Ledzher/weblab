package com.example.websitelab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "intern")
public class Intern extends BaseEntity{
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "description")
    private String description;
    @Column(name = "city")
    private String city;

    public Intern() {
    }


}
