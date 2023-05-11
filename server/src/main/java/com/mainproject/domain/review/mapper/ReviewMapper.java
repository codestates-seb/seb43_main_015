package com.mainproject.domain.review.mapper;

import com.mainproject.domain.review.dto.ReviewDto;
import com.mainproject.domain.review.dto.ReviewReplyDto;
import com.mainproject.domain.review.entity.Review;
import com.mainproject.domain.review.entity.ReviewReply;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    default Review reviewPostDtoToReview(ReviewDto.Post requestBody) {
        if (requestBody == null) {
            return null;
        }

        return Review.builder()
                .title(requestBody.getTitle())
                .content(requestBody.getContent())
                .build();
    }

    default Review reviewPatchDtoToReview(ReviewDto.Patch requestBody) {
        if (requestBody == null) {
            return null;
        }

        return Review.builder()
                .reviewId(requestBody.getReviewId())
                .title(requestBody.getTitle())
                .content(requestBody.getContent())
                .build();
    }

    default ReviewDto.Response reviewToReviewResponseDto(Review review, List<ReviewReply> reviewReplies) {
        if (review == null || reviewReplies == null) {
            return null;
        }

        return ReviewDto.Response.builder()
                .reviewId(review.getReviewId())
                .title(review.getTitle())
                .content(review.getContent())
                .reviewCreatedAt(review.getCreateAt())
                .reviewModifiedAt(review.getModifiedAt())
                .reviewReplies(reviewReplies)
                .build();
    }

    default ReviewDto.Response reviewToReviewResponseDto(Review review) {
        if (review == null) {
            return null;
        }

        return ReviewDto.Response.builder()
                .reviewId(review.getReviewId())
                .title(review.getTitle())
                .content(review.getContent())
                .reviewCreatedAt(review.getCreateAt())
                .reviewModifiedAt(review.getModifiedAt())
                .build();
    }

    default List<ReviewDto.Response> reviewsToReviewResponseDto(List<Review> reviews) {
        if (reviews == null) {
            return null;
        }

        return reviews.stream()
                .map(review -> ReviewDto.Response.builder()
                        .reviewId(review.getReviewId())
                        .title(review.getTitle())
                        .content(review.getContent())
                        .reviewCreatedAt(review.getCreateAt())
                        .reviewModifiedAt(review.getModifiedAt())
                        .build())
                .collect(Collectors.toList());
    }
}

