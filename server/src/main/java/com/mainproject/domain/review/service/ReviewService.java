package com.mainproject.domain.review.service;

import com.mainproject.domain.member.entity.Member;
import com.mainproject.domain.member.service.MemberService;
import com.mainproject.domain.review.entity.Review;
import com.mainproject.domain.review.repository.ReviewRepository;
import com.mainproject.global.exception.BusinessLogicException;
import com.mainproject.global.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberService memberService;

    public Review createReview( Review review) {
//        Member member = memberService.findMember(review.getMember().getMemberId());
//        review.getMember().setMemberId(member.getMemberId());

        return reviewRepository.save(review);
    }

    public Review findReview(Long reviewId) {
        return findVerifiedReview(reviewId);
    }

    public Page<Review> findAllReviews(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("reviewId").descending());
        return reviewRepository.findAll(pageable);
    }


    public Review updateReview(Review review, Long memberId) {
        verifiedReviewMember(memberId, review);
        return reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId) {
        Review review = findVerifiedReview(reviewId);
        reviewRepository.delete(review);
    }

    private Review findVerifiedReview(Long reviewId) {
        Optional<Review> id = reviewRepository.findById(reviewId);
        return id.orElseThrow(() -> new BusinessLogicException(ExceptionCode.REVIEW_NOT_FOUND));
    }

    public void verifyReview(Long reviewId) {
        Optional<Review> findReviewId = reviewRepository.findByReviewId(reviewId);
        if (findReviewId.isEmpty()) {
            throw new BusinessLogicException(ExceptionCode.REVIEW_NOT_FOUND);
        }
    }

    private void verifiedReviewMember(Long memberId, Review review) {
    }

    private void verifyMember(Member member, Long memberId) {
        if (!member.getMemberId().equals(memberId)) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_ALLOW);
        }
    }

}
