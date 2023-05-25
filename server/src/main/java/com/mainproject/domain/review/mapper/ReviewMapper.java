package com.mainproject.domain.review.mapper;

import com.mainproject.domain.member.entity.Member;
import com.mainproject.domain.review.dto.*;
import com.mainproject.domain.review.entity.Review;
import com.mainproject.domain.review.entity.ReviewReply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    default Review reviewPostDtoToReview(ReviewPostDto requestBody, Member member) {
        if (requestBody == null || member == null) {
            return null;
        }

        return Review.builder()
                .title(requestBody.getTitle())
                .content(requestBody.getContent())
                .member(member)
                .build();
    }

    Review reviewPatchDtoToReview(ReviewPatchDto requestBody);

    @Mapping(source = "createdAt", target = "reviewCreatedAt")
    @Mapping(source = "modifiedAt", target = "reviewModifiedAt")
    @Mapping(source = "member.memberId", target = "memberId")
    ReviewResponseDto reviewToReviewResponseDto(Review review);

    List<ReviewResponseDto> reviewsToReviewResponseDto(List<Review> reviews);


    default ReviewResponseDto reviewToReviewResponseDto(Review review, List<ReviewReply> reviewReplies) {
        if (review == null || reviewReplies == null) {
            return null;
        }

        return ReviewResponseDto.builder()
                .reviewId(review.getReviewId())
                .title(review.getTitle())
                .content(review.getContent())
                .reviewCreatedAt(review.getCreatedAt())
                .reviewModifiedAt(review.getModifiedAt())
                .reviewReplies(review.getReviewReplies())
                .reviewReplies(reviewReplies)
                .memberId(review.getMember().getMemberId())
                .build();
    }
}

