package com.backend.programming.learning.system.core.service.domain.implement.review;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.review.UpdateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.ReviewNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ReviewDeleteHelper {
    private final ReviewRepository reviewRepository;
    private final CertificateCourseRepository certificateCourseRepository;

    public ReviewDeleteHelper(ReviewRepository reviewRepository,
                              CertificateCourseRepository certificateCourseRepository) {
        this.reviewRepository = reviewRepository;
        this.certificateCourseRepository = certificateCourseRepository;
    }

    @Transactional
    public void deleteReviewById(DeleteReviewCommand deleteReviewCommand) {
        Review review = getReview(deleteReviewCommand.getReviewId());
        checkUserIsAllowedToDeleteReview(deleteReviewCommand, review);

        reviewRepository.deleteReviewById(deleteReviewCommand.getReviewId());
        log.info("Review with id: {} deleted successfully", deleteReviewCommand.getReviewId());
        Float avgRating = getAvgRatingOfAllReviewsByCertificateCourseId(review.getCertificateCourseId().getValue());
        int updatedRows = certificateCourseRepository.updateAvgRating(
                new CertificateCourseId(review.getCertificateCourseId().getValue()), avgRating);
        if (updatedRows == 0) {
            log.error("Could not update avg rating for certificate course with id: {}",
                    review.getCertificateCourseId().getValue());
            throw new CoreDomainException("Could not update avg rating for certificate course with id: " +
                    review.getCertificateCourseId().getValue());
        }
    }

    private void checkUserIsAllowedToDeleteReview(
            DeleteReviewCommand deleteReviewCommand, Review review) {
        // Check if user is a creator of the review
        checkUserOwnsReview(review, deleteReviewCommand.getDeletedBy());
    }

    private void checkUserOwnsReview(Review review, UUID userId) {
        if (!review.getCreatedBy().getId().getValue().equals(userId)) {
            log.error("User with id: {} is not allowed to update review with id: {}",
                    userId, review.getId().getValue());
            throw new CoreDomainException("User with id: " + userId +
                    " is not allowed to update review with id: " + review.getId().getValue());
        }
    }

    private Review getReview(UUID reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if (review.isEmpty()) {
            log.warn("Could not find review with id: {}", reviewId);
            throw new ReviewNotFoundException("Could not find review with id: " + reviewId);
        }
        return review.get();
    }

    private Float getAvgRatingOfAllReviewsByCertificateCourseId(UUID certificateCourseId) {
        return reviewRepository.getAvgRatingOfAllReviewsByCertificateCourseId(certificateCourseId);
    }
}