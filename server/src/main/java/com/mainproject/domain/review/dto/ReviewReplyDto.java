package com.mainproject.domain.review.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class ReviewReplyDto {

    @Getter
    @NoArgsConstructor
    public static class Post {
        @NotBlank
        private String content;

        private Long reviewId;

        public void setReviewId(Long reviewId) {
            this.reviewId = reviewId;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class Patch {
        private Long reviewReplyId;

        @NotBlank
        private String content;

        @Builder
        public Patch(Long reviewReplyId, String content) {
            this.reviewReplyId = reviewReplyId;
            this.content = content;
        }

        public void setReviewReplyId(Long reviewReplyId) {
            this.reviewReplyId = reviewReplyId;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class Response {
        private Long reviewReplyId;
        private String content;
        private LocalDateTime reviewReplyCreatedAt;
        private LocalDateTime reviewReplyModifiedAt;

//        private Long reviewId;


        @Builder
        public Response(Long reviewReplyId, String content, LocalDateTime reviewReplyCreatedAt, LocalDateTime reviewReplyModifiedAt, Long reviewId) {
            this.reviewReplyId = reviewReplyId;
            this.content = content;
            this.reviewReplyCreatedAt = reviewReplyCreatedAt;
            this.reviewReplyModifiedAt = reviewReplyModifiedAt;
//            this.reviewId = reviewId;
        }
    }
}
