package com.mainproject.domain.review.mapper;

import com.mainproject.domain.review.dto.reply.ReviewReplyPatchDto;
import com.mainproject.domain.review.dto.reply.ReviewReplyPostDto;
import com.mainproject.domain.review.dto.reply.ReviewReplyResponseDto;
import com.mainproject.domain.review.entity.ReviewReply;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewReplyMapper {
    ReviewReply reviewReplyPostDtoToReviewReply(ReviewReplyPostDto requestBody);
    ReviewReply reviewReplyPatchDtoToReviewReply(ReviewReplyPatchDto requestBody);

    ReviewReplyResponseDto reviewReplyToReviewReplyResponseDto(ReviewReply reviewReply);

    List<ReviewReplyResponseDto> reviewRepliesToReviewReplyResponseDto(List<ReviewReply> reviewReplies);
//    default ReviewReply reviewReplyPostDtoToReviewReply(ReviewReplyDto.Post requestBody) {
//        if (requestBody == null) {
//            return null;
//        }
//
//        return ReviewReply.builder()
//                .content(requestBody.getContent())
//                .review(Review.builder().reviewId(requestBody.getReviewId()).build())
//                .build();
//    }
//
//    default ReviewReply reviewReplyPatchDtoToReviewReply(ReviewReplyDto.Patch requestBody) {
//        if (requestBody == null) {
//            return null;
//        }
//
//        return ReviewReply.builder()
//                .reviewReplyId(requestBody.getReviewReplyId())
//                .content(requestBody.getContent())
//                .build();
//    }
//
//    default ReviewReplyDto.Response reviewReplyToReviewReplyResponseDto(ReviewReply reviewReply) {
//        if (reviewReply == null) {
//            return null;
//        }
//
//        return ReviewReplyDto.Response.builder()
//                .reviewReplyId(reviewReply.getReviewReplyId())
//                .content(reviewReply.getContent())
////                .reviewId(reviewReply.getReview().getReviewId())
//                .reviewReplyCreatedAt(reviewReply.getCreatedAt())
//                .reviewReplyModifiedAt(reviewReply.getModifiedAt())
//                .build();
//    }
//
//    default List<ReviewReplyDto.Response> reviewRepliesToReviewReplyResponseDto(List<ReviewReply> reviewReplies) {
//        if (reviewReplies == null) {
//            return null;
//        }
//
//        return reviewReplies.stream()
//                .map(reviewReply -> ReviewReplyDto.Response.builder()
//                        .reviewReplyId(reviewReply.getReviewReplyId())
//                        .content(reviewReply.getContent())
////                .reviewId(reviewReply.getReview().getReviewId())
//                        .reviewReplyCreatedAt(reviewReply.getCreatedAt())
//                        .reviewReplyModifiedAt(reviewReply.getModifiedAt())
//                        .build())
//                .collect(Collectors.toList());
//    }
}

