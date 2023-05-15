package com.mainproject.domain.review.dto.reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewReplyResponseDto {
    private Long reviewReplyId;
    private String content;
    private LocalDateTime reviewReplyCreatedAt;
    private LocalDateTime reviewReplyModifiedAt;
}
