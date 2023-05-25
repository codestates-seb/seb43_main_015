package com.mainproject.domain.review.controller;

import com.mainproject.domain.member.entity.Member;
import com.mainproject.domain.member.service.MemberService;
import com.mainproject.domain.review.dto.ReviewPatchDto;
import com.mainproject.domain.review.dto.ReviewPostDto;
import com.mainproject.domain.review.entity.Review;
import com.mainproject.domain.review.entity.ReviewReply;
import com.mainproject.domain.review.mapper.ReviewMapper;
import com.mainproject.domain.review.service.ReviewService;
import com.mainproject.global.response.MultiResponseDto;
import com.mainproject.global.response.SingleResponseDto;
import com.mainproject.global.security.auth.loginresolver.LoginMemberId;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewMapper mapper;
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity postReview(@Valid @RequestBody ReviewPostDto requestBody,
                                     @LoginMemberId Long memberId) {
        Member member = memberService.findMember(memberId);
        Review review = mapper.reviewPostDtoToReview(requestBody, member);
        Review createReview = reviewService.createReview(review);

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.reviewToReviewResponseDto(createReview)), HttpStatus.CREATED
        );
    }

    //    @PatchMapping("/{review-id}/{member-id}")
    public ResponseEntity patchReview(@Valid @RequestBody ReviewPatchDto requestBody,
                                      @PathVariable("review-id") Long reviewId,
                                      @PathVariable("member-id") Long memberId) {
        requestBody.setReviewId(reviewId);
        memberService.findMember(memberId);
        Review review = mapper.reviewPatchDtoToReview(requestBody);
        Review updateReview = reviewService.updateReview(review, memberId);
        List<ReviewReply> reviewReplies = review.getReviewReplies();
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.reviewToReviewResponseDto(updateReview, reviewReplies)), HttpStatus.CREATED
        );
    }

    @GetMapping("/{review-id}")
    public ResponseEntity findReview(@PathVariable("review-id") Long reviewId) {
        Review review = reviewService.findReview(reviewId);
        List<ReviewReply> reviewReplies = review.getReviewReplies();
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.reviewToReviewResponseDto(review, reviewReplies)), HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity findAllReview(@RequestParam int page, @RequestParam int size) {
        Page<Review> allReviews = reviewService.findAllReviews(page - 1, size);
        List<Review> reviews = allReviews.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.reviewsToReviewResponseDto(reviews), allReviews), HttpStatus.OK
        );
    }

    @DeleteMapping("/{review-id}")
    public ResponseEntity deleteReview(@PathVariable("review-id") Long reviewId) {
        reviewService.deleteReview(reviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
