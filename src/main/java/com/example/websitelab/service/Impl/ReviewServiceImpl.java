package com.example.websitelab.service.Impl;

import com.example.websitelab.dto.ReviewsDto;
import com.example.websitelab.entity.Reviews;
import com.example.websitelab.repository.ReviewsRepository;
import com.example.websitelab.service.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewsService {
    private final ReviewsRepository reviewsRepository;

    @Override
    public Reviews createNewReview(ReviewsDto reviewsDto) {
        Reviews reviews = new Reviews();
        reviews.setFullName(reviewsDto.getFullName());
        reviews.setReview(reviewsDto.getReview());

        return reviewsRepository.save(reviews);
    }
    @Override
    public List<Reviews> getAllReviews(){
        return reviewsRepository.findAll();
    }
    @Override
    public Reviews deleteReview(Long reviewId) {
        if (Objects.isNull(reviewId)) {
            System.out.println("Null");
        }
        Optional<Reviews> optionalReview = reviewsRepository.findById(reviewId);
        return optionalReview.map(review -> {
            reviewsRepository.delete(review);
            return review;
        }).orElse(null);
    }

    @Override
    public Reviews updateReview(Long reviewId, ReviewsDto updatedReviewDto) {
        if (Objects.isNull(reviewId) || Objects.isNull(updatedReviewDto)) {
            System.out.println("Null");
        }

        Optional<Reviews> optionalReview = reviewsRepository.findById(reviewId);
        return optionalReview.map(review -> {
            review.setFullName(updatedReviewDto.getFullName());
            review.setReview(updatedReviewDto.getReview());
            return reviewsRepository.save(review);
        }).orElse(null);
    }
}
