package com.example.websitelab.service;

import com.example.websitelab.dto.ReviewsDto;
import com.example.websitelab.entity.Reviews;

import java.util.List;

public interface ReviewsService {
    Reviews createNewReview(ReviewsDto reviewsDto);

    List<Reviews> getAllReviews();



    Reviews deleteReview(Long reviewId);

    Reviews updateReview(Long reviewId, ReviewsDto updatedReviewDto);
}
