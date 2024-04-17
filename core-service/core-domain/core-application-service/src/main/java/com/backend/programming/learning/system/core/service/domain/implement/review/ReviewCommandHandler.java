package com.backend.programming.learning.system.core.service.domain.implement.review;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.review.ReviewResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.mapper.review.ReviewDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class ReviewCommandHandler {
    private final ReviewCreateHelper reviewCreateHelper;
    private final ReviewQueryHelper reviewQueryHelper;
    private final ReviewDeleteHelper reviewDeleteHelper;
    private final ReviewDataMapper reviewDataMapper;

    public ReviewCommandHandler(ReviewCreateHelper reviewCreateHelper,
                                ReviewQueryHelper reviewQueryHelper,
                                ReviewDeleteHelper reviewDeleteHelper,
                                ReviewDataMapper reviewDataMapper) {
        this.reviewCreateHelper = reviewCreateHelper;
        this.reviewQueryHelper = reviewQueryHelper;
        this.reviewDeleteHelper = reviewDeleteHelper;
        this.reviewDataMapper = reviewDataMapper;
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

    @Transactional(readOnly = true)
    public QueryAllReviewsResponse findAllReviewsResponse(
            QueryAllReviewsCommand queryAllReviewsCommand
    ) {
        Page<Review> reviews = reviewQueryHelper
                .queryAllReviewsByCertificateCourseId(
                        queryAllReviewsCommand.getCertificateCourseId(),
                        queryAllReviewsCommand.getPageNo(),
                        queryAllReviewsCommand.getPageSize());

        return reviewDataMapper.reviewsToQueryAllReviewsResponse(reviews);
    }

    @Transactional(readOnly = true)
    public ReviewResponseEntity findReviewResponseById(
            QueryReviewCommand queryReviewCommand
    ) {
        Review review = reviewQueryHelper
                .queryReviewById(queryReviewCommand.getReviewId());

        log.info("Review found with id: {}", review.getId().getValue());

        return reviewDataMapper.reviewToQueryReviewResponse(review);
    }

    @Transactional
    public DeleteReviewResponse deleteReviewResponse(
            DeleteReviewCommand deleteReviewCommand
    ) {
        reviewDeleteHelper
                .deleteReviewById(deleteReviewCommand.getReviewId());

        log.info("Review deleted with id: {}", deleteReviewCommand.getReviewId());

        return DeleteReviewResponse.builder()
                .reviewId(deleteReviewCommand.getReviewId())
                .message("Review deleted successfully")
                .build();
    }

}
