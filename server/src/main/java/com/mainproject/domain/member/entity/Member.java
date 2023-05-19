package com.mainproject.domain.member.entity;

import com.mainproject.domain.review.entity.Review;
import com.mainproject.domain.review.entity.ReviewReply;
import com.mainproject.global.audit.Auditable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, updatable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @Builder
    public Member(Long memberId, String email, String password, String username) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<Review> reviews;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<ReviewReply> reviewReplies;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    public enum MemberRole {
        ROLE_USER,
        ROLE_ADMIN
    }

}
