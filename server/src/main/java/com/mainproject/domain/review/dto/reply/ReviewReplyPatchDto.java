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
public class ReviewReplyPatchDto {
    private Long reviewReplyId;

    @NotBlank
    private String content;

    public void setReviewReplyId(Long reviewReplyId) {
        this.reviewReplyId = reviewReplyId;
    }
}
