package com.mainproject.domain.review.dto.reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewReplyPostDto {
    @NotBlank
    private String content;

    private Long reviewId;

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
}
