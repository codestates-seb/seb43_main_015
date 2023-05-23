package com.mainproject.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewPostDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    private Long memberId;
}
