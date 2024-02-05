package com.example.websitelab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "dev")
public class Dev extends BaseEntity{
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "password")
    private String password;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "description")
    private String description;
    @Column(name = "contacts")
    private String contacts;

    private  byte[] photoData;
}
