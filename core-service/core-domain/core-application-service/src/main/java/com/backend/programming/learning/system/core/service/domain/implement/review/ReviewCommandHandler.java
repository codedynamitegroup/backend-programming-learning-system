package com.backend.programming.learning.system.core.service.domain.implement.review;

import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.mapper.review.ReviewDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class ReviewCommandHandler {
    private final ReviewCreateHelper reviewCreateHelper;
    private final ReviewDataMapper reviewDataMapper;
    private final ReviewRepository reviewRepository;

    public ReviewCommandHandler(ReviewCreateHelper reviewCreateHelper,
                                ReviewDataMapper reviewDataMapper,
                                ReviewRepository reviewRepository) {
        this.reviewCreateHelper = reviewCreateHelper;
        this.reviewDataMapper = reviewDataMapper;
        this.reviewRepository = reviewRepository;
    }

    @Transactional
    public CreateReviewResponse createReviewResponse(
            CreateReviewCommand createReviewCommand) {
        Review review = reviewCreateHelper
                .persistReview(createReviewCommand);

        log.info("Review created with id: {}", review.getId().getValue());

        return reviewDataMapper.reviewToCreateReviewResponse(review,
                "Review created successfully");
    }

}
