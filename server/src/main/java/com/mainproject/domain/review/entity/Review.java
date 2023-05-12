package com.mainproject.domain.review.entity;


import com.mainproject.domain.member.entity.Member;
import com.mainproject.global.audit.Auditable;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
