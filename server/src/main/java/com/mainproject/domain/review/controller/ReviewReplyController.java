package com.mainproject.domain.review.controller;

import com.mainproject.domain.review.dto.ReviewReplyDto;
import com.mainproject.domain.review.entity.Review;
import com.mainproject.domain.review.entity.ReviewReply;
import com.mainproject.domain.review.mapper.ReviewReplyMapper;
import com.mainproject.domain.review.service.ReviewReplyService;
import com.mainproject.domain.review.service.ReviewService;
import com.mainproject.global.response.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewReplyController {
    private final ReviewReplyService reviewReplyService;
    private final ReviewService reviewService;
    private final ReviewReplyMapper mapper;

    @PostMapping("/{review-id}/reply")
    public ResponseEntity postReviewReply(@PathVariable("review-id") Long reviewId,
                                          @RequestBody ReviewReplyDto.Post requestBody) {
//        requestBody.setReviewId(reviewId);

        ReviewReply reviewReply = mapper.reviewReplyPostDtoToReviewReply(requestBody);
        ReviewReply createReply = reviewReplyService.createReply(reviewReply, reviewId);
//        ReviewReply createReply = reviewReplyService.createReply(reviewReply);
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.reviewReplyToReviewReplyResponseDto(createReply)), HttpStatus.CREATED
        );
    }


    @PatchMapping("/{review-id}/reply/{reviewReply-id}")
    public ResponseEntity updateReviewReply(@PathVariable("review-id") Long reviewId,
                                            @PathVariable("reviewReply-id") Long reviewReplyId,
                                            @RequestBody ReviewReplyDto.Patch requestBody) {
        requestBody.setReviewReplyId(reviewReplyId);
        ReviewReply reviewReply = mapper.reviewReplyPatchDtoToReviewReply(requestBody);
        ReviewReply updateReply = reviewReplyService.updateReply(reviewReply);
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.reviewReplyToReviewReplyResponseDto(updateReply)), HttpStatus.OK
        );
    }

    @GetMapping("/{review-id}/reply/{reviewReply-id}")
    public ResponseEntity findReviewReply(@PathVariable("review-id") Long reviewId,
                                          @PathVariable("reviewReply-id") Long reviewReplyId) {
        ReviewReply reviewReply = reviewReplyService.findReply(reviewId, reviewReplyId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.reviewReplyToReviewReplyResponseDto(reviewReply)), HttpStatus.OK
        );
    }

    @DeleteMapping("/{review-id}/reply/{reviewReply-id}")
    public ResponseEntity deleteReviewReply(@PathVariable("review-id") Long reviewId,
                                            @PathVariable("reviewReply-id") Long reviewReplyId) {
        reviewReplyService.deleteReply(reviewId, reviewReplyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
