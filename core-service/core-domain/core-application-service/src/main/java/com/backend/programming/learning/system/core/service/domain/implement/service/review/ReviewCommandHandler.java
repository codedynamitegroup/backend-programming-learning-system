package com.backend.programming.learning.system.core.service.domain.implement.service.review;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryEachStarReviewCountResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.review.UpdateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.review.UpdateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.review.ReviewResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.mapper.review.ReviewDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.ReviewId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@Slf4j
public class ReviewCommandHandler {
    private final ReviewCreateHelper reviewCreateHelper;
    private final ReviewQueryHelper reviewQueryHelper;
    private final ReviewDeleteHelper reviewDeleteHelper;
    private final ReviewUpdateHelper reviewUpdateHelper;
    private final ReviewDataMapper reviewDataMapper;
    private final ReviewRepository reviewRepository;

    public ReviewCommandHandler(ReviewCreateHelper reviewCreateHelper,
                                ReviewQueryHelper reviewQueryHelper,
                                ReviewDeleteHelper reviewDeleteHelper,
                                ReviewUpdateHelper reviewUpdateHelper,
                                ReviewDataMapper reviewDataMapper, ReviewRepository reviewRepository) {
        this.reviewCreateHelper = reviewCreateHelper;
        this.reviewQueryHelper = reviewQueryHelper;
        this.reviewDeleteHelper = reviewDeleteHelper;
        this.reviewUpdateHelper = reviewUpdateHelper;
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
    public QueryEachStarReviewCountResponse findEachStarReviewCountResponse(
            UUID certificateCourseId
    ) {
        Integer eachStarReviewCount = reviewRepository.countNumOfReviewsByCertificateCourseIdAndRating(certificateCourseId, 1);
        Integer twoStarReviewCount = reviewRepository.countNumOfReviewsByCertificateCourseIdAndRating(certificateCourseId, 2);
        Integer threeStarReviewCount = reviewRepository.countNumOfReviewsByCertificateCourseIdAndRating(certificateCourseId, 3);
        Integer fourStarReviewCount = reviewRepository.countNumOfReviewsByCertificateCourseIdAndRating(certificateCourseId, 4);
        Integer fiveStarReviewCount = reviewRepository.countNumOfReviewsByCertificateCourseIdAndRating(certificateCourseId, 5);
        Integer numOfReviews = reviewRepository.countNumOfReviewsByCertificateCourseId(certificateCourseId);
        Float avgRating = reviewRepository.getAvgRatingOfAllReviewsByCertificateCourseId(certificateCourseId);

        return QueryEachStarReviewCountResponse.builder()
                .numOfOneStarReviews(eachStarReviewCount)
                .numOfTwoStarReviews(twoStarReviewCount)
                .numOfThreeStarReviews(threeStarReviewCount)
                .numOfFourStarReviews(fourStarReviewCount)
                .numOfFiveStarReviews(fiveStarReviewCount)
                .numOfReviews(numOfReviews)
                .avgRating(avgRating)
                .build();
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
        reviewDeleteHelper.deleteReviewById(deleteReviewCommand);

        log.info("Review deleted with id: {}", deleteReviewCommand.getReviewId());

        return DeleteReviewResponse.builder()
                .reviewId(deleteReviewCommand.getReviewId())
                .message("Review deleted successfully")
                .build();
    }

    @Transactional
    public UpdateReviewResponse updateReviewResponse(
            UpdateReviewCommand updateReviewCommand
    ) {
        reviewUpdateHelper.persistReview(updateReviewCommand);

        log.info("Review updated with id: {}", updateReviewCommand.getReviewId());

        return reviewDataMapper.reviewToUpdateReviewResponse(
                new ReviewId(updateReviewCommand.getReviewId()),
                "Review updated successfully");
    }

}
