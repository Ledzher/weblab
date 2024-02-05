package com.example.websitelab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "news")
public class News extends BaseEntity{

    @Column(name = "text")
    private String text;
}
