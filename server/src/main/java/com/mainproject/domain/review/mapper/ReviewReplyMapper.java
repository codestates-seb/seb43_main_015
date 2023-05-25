package com.mainproject.domain.review.mapper;

import com.mainproject.domain.member.entity.Member;
import com.mainproject.domain.review.dto.reply.ReviewReplyPatchDto;
import com.mainproject.domain.review.dto.reply.ReviewReplyPostDto;
import com.mainproject.domain.review.dto.reply.ReviewReplyResponseDto;
import com.mainproject.domain.review.entity.Review;
import com.mainproject.domain.review.entity.ReviewReply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewReplyMapper {

    default ReviewReply reviewReplyPostDtoToReviewReply(ReviewReplyPostDto requestBody, Member member, Review review) {
        if (requestBody == null || member == null) {
            return null;
        }

        return ReviewReply.builder()
                .content(requestBody.getContent())
                .member(member)
                .review(review)
                .build();
    }
    ReviewReply reviewReplyPatchDtoToReviewReply(ReviewReplyPatchDto requestBody);

    @Mapping(source = "createdAt", target = "reviewReplyCreatedAt")
    @Mapping(source = "modifiedAt", target = "reviewReplyModifiedAt")
    ReviewReplyResponseDto reviewReplyToReviewReplyResponseDto(ReviewReply reviewReply);

    List<ReviewReplyResponseDto> reviewRepliesToReviewReplyResponseDto(List<ReviewReply> reviewReplies);



}

