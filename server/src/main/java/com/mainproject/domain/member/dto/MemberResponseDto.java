package com.mainproject.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {
    private Long memberId;
    private String email;
//    private String password;
    private String username;
    private LocalDateTime memberCreatedAt;
    private LocalDateTime memberModifiedAt;
}
