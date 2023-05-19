package com.mainproject.domain.review.mapper;

import com.mainproject.domain.review.dto.*;
import com.mainproject.domain.review.entity.Review;
import com.mainproject.domain.review.entity.ReviewReply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
//    @Mapping(source = "memberId", target = "member.memberId")
    Review reviewPostDtoToReview(ReviewPostDto requestBody);

    Review reviewPatchDtoToReview(ReviewPatchDto requestBody);

    ReviewResponseDto reviewToReviewResponseDto(Review review, List<ReviewReply> reviewReplies);

    @Mapping(source = "createdAt", target = "reviewCreatedAt")
    @Mapping(source = "modifiedAt", target = "reviewModifiedAt")
//    @Mapping(source = "memberId", target = "member.memberId")
    ReviewResponseDto reviewToReviewResponseDto(Review review);

    List<ReviewResponseDto> reviewsToReviewResponseDto(List<Review> reviews);
//    default Review reviewPostDtoToReview(ReviewDto.Post requestBody) {
//        if (requestBody == null) {
//            return null;
//        }
//
//        return Review.builder()
//                .title(requestBody.getTitle())
//                .content(requestBody.getContent())
//                .build();
//    }
//
//    default Review reviewPatchDtoToReview(ReviewDto.Patch requestBody) {
//        if (requestBody == null) {
//            return null;
//        }
//
//        return Review.builder()
//                .reviewId(requestBody.getReviewId())
//                .title(requestBody.getTitle())
//                .content(requestBody.getContent())
//                .build();
//    }
//
//    default ReviewDto.Response reviewToReviewResponseDto(Review review, List<ReviewReply> reviewReplies) {
//        if (review == null || reviewReplies == null) {
//            return null;
//        }
//
//        return ReviewDto.Response.builder()
//                .reviewId(review.getReviewId())
//                .title(review.getTitle())
//                .content(review.getContent())
//                .reviewCreatedAt(review.getCreatedAt())
//                .reviewModifiedAt(review.getModifiedAt())
////                .reviewReplies(reviewReplies)
////                .reviewReplies(review.getReviewReplies()) // ?
//                .build();
//    }
//
//    default ReviewDto.Response reviewToReviewResponseDto(Review review) {
//        if (review == null) {
//            return null;
//        }
//
//        return ReviewDto.Response.builder()
//                .reviewId(review.getReviewId())
//                .title(review.getTitle())
//                .content(review.getContent())
//                .reviewCreatedAt(review.getCreatedAt())
//                .reviewModifiedAt(review.getModifiedAt())
//                .build();
//    }
//
//    default List<ReviewDto.Response> reviewsToReviewResponseDto(List<Review> reviews) {
//        if (reviews == null) {
//            return null;
//        }
//
//        return reviews.stream()
//                .map(review -> ReviewDto.Response.builder()
//                        .reviewId(review.getReviewId())
//                        .title(review.getTitle())
//                        .content(review.getContent())
//                        .reviewCreatedAt(review.getCreatedAt())
//                        .reviewModifiedAt(review.getModifiedAt())
//                        .build())
//                .collect(Collectors.toList());
//    }
}

