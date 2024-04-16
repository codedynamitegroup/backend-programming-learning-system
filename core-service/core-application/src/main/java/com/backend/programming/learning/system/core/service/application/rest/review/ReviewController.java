package com.backend.programming.learning.system.core.service.application.rest.review;

import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.review.ReviewApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
