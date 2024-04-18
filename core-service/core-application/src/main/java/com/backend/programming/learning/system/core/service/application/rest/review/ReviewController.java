package com.backend.programming.learning.system.core.service.application.rest.review;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.review.UpdateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.review.UpdateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.review.ReviewResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.review.ReviewApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/reviews", produces = "application/vnd.api.v1+json")
public class ReviewController {
    private final ReviewApplicationService reviewApplicationService;

    public ReviewController(ReviewApplicationService reviewApplicationService) {
        this.reviewApplicationService = reviewApplicationService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateReviewResponse> createReview(
            @RequestBody CreateReviewCommand createReviewCommand) {
        log.info("Creating review: {}", createReviewCommand);
        CreateReviewResponse createReviewResponse =
                reviewApplicationService.createReview(createReviewCommand);
        log.info("Review created: {}", createReviewResponse);

        return ResponseEntity.ok(createReviewResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateReviewResponse> updateReview(
            @PathVariable UUID id,
            @RequestBody UpdateReviewCommand updateReviewCommand) {
        log.info("Updating review: {}", id);
        UpdateReviewResponse updateReviewResponse =
                reviewApplicationService.updateReview(UpdateReviewCommand
                        .builder()
                        .reviewId(id)
                        .rating(updateReviewCommand.getRating())
                        .content(updateReviewCommand.getContent())
                        .updatedBy(updateReviewCommand.getUpdatedBy())
                        .build());
        log.info("Review updated: {}", updateReviewResponse.getReviewId());
        return ResponseEntity.ok(updateReviewResponse);
    }

    @GetMapping
    public ResponseEntity<QueryAllReviewsResponse> getAllReviewsByCertificateCourseId(
            @RequestParam UUID certificateCourseId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        QueryAllReviewsResponse queryAllReviewsResponse =
                reviewApplicationService.queryAllReviewsByCertificateCourseId(QueryAllReviewsCommand
                        .builder()
                        .certificateCourseId(certificateCourseId)
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .build());
        log.info("Returning all reviews: {}", queryAllReviewsResponse);
        return ResponseEntity.ok(queryAllReviewsResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseEntity> getReview(
            @PathVariable UUID id) {
        ReviewResponseEntity reviewResponseEntity =
                reviewApplicationService.queryReview(QueryReviewCommand
                        .builder()
                        .reviewId(id)
                        .build());
        log.info("Returning review: {}", reviewResponseEntity);
        return ResponseEntity.ok(reviewResponseEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteReviewResponse> deleteReview(
            @PathVariable UUID id,
            @RequestParam UUID deletedBy) {
        DeleteReviewResponse deleteReviewResponse =
                reviewApplicationService.deleteReview(DeleteReviewCommand
                        .builder()
                        .reviewId(id)
                        .deletedBy(deletedBy)
                        .build());
        log.info("Review deleted: {}", id);
        return ResponseEntity.ok(deleteReviewResponse);
    }

}
