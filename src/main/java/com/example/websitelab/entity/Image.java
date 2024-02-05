package com.example.websitelab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "image")
public class Image extends BaseEntity {

   @Column(name = "file_name")
    private String fileName;

    @Column(columnDefinition = "bytea")
    private byte[] data;


}