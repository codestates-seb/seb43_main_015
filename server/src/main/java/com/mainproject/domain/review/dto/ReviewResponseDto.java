package com.mainproject.domain.review.dto;

import com.mainproject.domain.review.entity.ReviewReply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDto {
    private Long reviewId;
    private String title;
    private String content;
    private LocalDateTime reviewCreatedAt;
    private LocalDateTime reviewModifiedAt;
    private List<ReviewReply> reviewReplies;
    private Long memberId;
}
