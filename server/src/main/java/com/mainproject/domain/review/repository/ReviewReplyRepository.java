package com.mainproject.domain.review.repository;

import com.mainproject.domain.review.entity.ReviewReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewReplyRepository extends JpaRepository<ReviewReply, Long> {
    Optional<ReviewReply> findByReviewReviewIdAndReviewReplyId(Long reviewId, Long reviewReplyId);
}
