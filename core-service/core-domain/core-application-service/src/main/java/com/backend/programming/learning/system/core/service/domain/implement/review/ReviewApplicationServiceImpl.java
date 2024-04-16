package com.backend.programming.learning.system.core.service.domain.implement.review;

import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.review.ReviewApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
@Slf4j
class ReviewApplicationServiceImpl implements ReviewApplicationService {
    private final ReviewCommandHandler reviewCommandHandler;

    public ReviewApplicationServiceImpl(ReviewCommandHandler reviewCommandHandler) {
        this.reviewCommandHandler = reviewCommandHandler;
    }

    @Override
    public CreateReviewResponse createReview(@Valid CreateReviewCommand createReviewCommand) {
        return reviewCommandHandler.createReviewResponse(createReviewCommand);
    }
}
