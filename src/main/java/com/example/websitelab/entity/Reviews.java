package com.example.websitelab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Reviews extends BaseEntity {
    @Size(max = 255, message = "Максимальная длина имени - 255 символов")
    @Column(name = "full_name")
    private String fullName;

    @Size(max = 1000, message = "Максимальная длина отзыва - 1000 символов")
    @Column(name = "review")
    private String review;
}
