package com.mainproject.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberPatchDto {
    private Long memberId;

    @NotBlank
    private String password;

    @NotBlank
    private String username;

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
