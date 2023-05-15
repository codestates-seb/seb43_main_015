package com.mainproject.domain.review.dto;

import com.mainproject.domain.review.entity.ReviewReply;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewDto {

    @Getter
    @NoArgsConstructor
    public static class Post {
        @NotBlank
        private String title;

        @NotBlank
        private String content;
    }

    @Getter
    @NoArgsConstructor
    public static class Patch {
        private Long reviewId;

        @NotBlank
        private String title;

        @NotBlank
        private String content;

        @Builder
        public Patch(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public void setReviewId(Long reviewId) {
            this.reviewId = reviewId;
        }

    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Response {
        private Long reviewId;
        private String title;
        private String content;
        private LocalDateTime reviewCreatedAt;
        private LocalDateTime reviewModifiedAt;
        private List<ReviewReply> reviewReplies;
        private Long memberId;
    }

}
