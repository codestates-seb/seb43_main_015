package com.mainproject.domain.review.mapper;

import com.mainproject.domain.review.dto.ReviewDto;
import com.mainproject.domain.review.dto.ReviewReplyDto;
import com.mainproject.domain.review.entity.Review;
import com.mainproject.domain.review.entity.ReviewReply;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ReviewReplyMapper {

    default ReviewReply reviewReplyPostDtoToReviewReply(ReviewReplyDto.Post requestBody) {
        if (requestBody == null) {
            return null;
        }

        return ReviewReply.builder()

                .content(requestBody.getContent())
                .build();
    }

    default ReviewReply reviewReplyPatchDtoToReviewReply(ReviewReplyDto.Patch requestBody) {
        if (requestBody == null) {
            return null;
        }

        return ReviewReply.builder()
                .reviewReplyId(requestBody.getReviewReplyId())
                .content(requestBody.getContent())
                .build();
    }

    default ReviewReplyDto.Response reviewReplyToReviewReplyResponseDto(ReviewReply reviewReply) {
        if (reviewReply == null) {
            return null;
        }

        return ReviewReplyDto.Response.builder()
                .reviewReplyId(reviewReply.getReviewReplyId())
                .content(reviewReply.getContent())
//                .reviewId(reviewReply.getReview().getReviewId())
                .reviewReplyCreatedAt(reviewReply.getCreateAt())
                .reviewReplyModifiedAt(reviewReply.getModifiedAt())
                .build();
    }

    default List<ReviewReplyDto.Response> reviewRepliesToReviewReplyResponseDto(List<ReviewReply> reviewReplies) {
        if (reviewReplies == null) {
            return null;
        }

        return reviewReplies.stream()
                .map(reviewReply -> ReviewReplyDto.Response.builder()
                        .reviewReplyId(reviewReply.getReviewReplyId())
                        .content(reviewReply.getContent())
//                .reviewId(reviewReply.getReview().getReviewId())
                        .reviewReplyCreatedAt(reviewReply.getCreateAt())
                        .reviewReplyModifiedAt(reviewReply.getModifiedAt())
                        .build())
                .collect(Collectors.toList());
    }
}

