package com.mainproject.domain.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberPostDto {
    @Schema(example = "email@email.com")
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String username;
}
