package com.mainproject.domain.review.entity;


import com.mainproject.global.audit.Auditable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewReply> reviewReplies;

    @Builder
    public Review(Long reviewId, String title, String content, List<ReviewReply> reviewReplies) {
        this.reviewId = reviewId;
        this.title = title;
        this.content = content;
        this.reviewReplies = reviewReplies;
    }
}
