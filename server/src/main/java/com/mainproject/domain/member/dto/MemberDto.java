package com.mainproject.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class MemberDto {

    @Getter
    @NoArgsConstructor
    public static class Post {
        @Email
        private String email;

        @NotBlank
        private String password;

        @NotBlank
        private String username;
    }

    @Getter
    @NoArgsConstructor
    public static class Patch {
        private Long memberId;

        @NotBlank
        private String password;

        @NotBlank
        private String username;

        @Builder
        public Patch(String password, String username) {
            this.password = password;
            this.username = username;
        }

        public void setMemberId(Long memberId) {
            this.memberId = memberId;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class Response {
        private Long memberId;
        private String email;
        private String password;
        private String username;
        private LocalDateTime memberCreatedAt;

        @Builder
        public Response(Long memberId, String email, String password, String username, LocalDateTime memberCreatedAt) {
            this.memberId = memberId;
            this.email = email;
            this.password = password;
            this.username = username;
            this.memberCreatedAt = memberCreatedAt;
        }
    }
}
