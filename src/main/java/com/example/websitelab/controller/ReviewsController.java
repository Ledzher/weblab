package com.example.websitelab.controller;

import com.example.websitelab.dto.ReviewsDto;
import com.example.websitelab.entity.Reviews;
import com.example.websitelab.service.ReviewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
@Tag(name= "Api для отзывов")
public class ReviewsController {
    private final ReviewsService reviewsService;

    @PostMapping("/create")
    @Operation(summary= "Сохранение отзывов.Укажите необходимые данные для сохранение")
    public ResponseEntity<Reviews> createNewAppReviews(
            @Valid
            @RequestBody ReviewsDto reviewsDto){
        return ResponseEntity.ok(this.reviewsService.createNewReview(reviewsDto));
    }

    @GetMapping("/get-all")
    @Operation(summary= "Получение отзывов" )
    public ResponseEntity<List<Reviews>> getAllReviews(){
        return ResponseEntity.ok(reviewsService.getAllReviews());
    }

}
