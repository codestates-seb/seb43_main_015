package com.mainproject.domain.member.entity;

import com.mainproject.domain.review.entity.Review;
import com.mainproject.domain.review.entity.ReviewReply;
import com.mainproject.global.audit.Auditable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
}
