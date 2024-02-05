package com.example.websitelab.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsDto {

    @Size(max = 255, message = "Максимальная длина имени - 255 символов")
    private String fullName;

    @Size(max = 1000, message = "Максимальная длина отзыва - 1000 символов")
    private String review;

}
