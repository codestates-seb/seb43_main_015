package com.mainproject.domain.review.service;

import com.mainproject.domain.review.entity.ReviewReply;
import com.mainproject.domain.review.repository.ReviewReplyRepository;
import com.mainproject.global.exception.BusinessLogicException;
import com.mainproject.global.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ReviewReplyService {
    private final ReviewService reviewService;
    private final ReviewReplyRepository reviewReplyRepository;

    @Transactional
    public ReviewReply createReply(ReviewReply reviewReply, Long reviewId) {
        reviewService.verifyReview(reviewId);
        reviewReply.getReview().setReviewId(reviewId); // reviewId 저장
        reviewReply.getMember().setMemberId(reviewId); // TODO: memberId 넣기
        return reviewReplyRepository.save(reviewReply);
    }

    public ReviewReply findReply(Long reviewId, Long reviewReplyId) {
        return reviewReplyRepository.findByReviewReviewIdAndReviewReplyId(reviewId, reviewReplyId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.REVIEW_NOT_FOUND));
    }

    @Transactional
    public ReviewReply updateReply(ReviewReply reviewReply) {
        // TODO: 회원검증
        return reviewReplyRepository.save(reviewReply);
    }

    @Transactional
    public void deleteReply(Long reviewId, Long reviewReplyId) {
        ReviewReply reviewReply = findReply(reviewId, reviewReplyId);
        reviewReplyRepository.delete(reviewReply);

    }

}
