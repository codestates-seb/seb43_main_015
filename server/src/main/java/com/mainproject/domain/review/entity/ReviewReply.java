package com.mainproject.domain.review.entity;

import com.mainproject.global.audit.Auditable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ReviewReply extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_reply_id")
    private Long reviewReplyId;

    @Column(nullable = false)
    private String content;

//    @Builder
//    public ReviewReply(Long reviewReplyId, String content) {
//        this.reviewReplyId = reviewReplyId;
//        this.content = content;
//    }

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @Builder
    public ReviewReply(Long reviewReplyId, String content, Review review) {
        this.reviewReplyId = reviewReplyId;
        this.content = content;
        this.review = review;
    }
}
