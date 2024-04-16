package com.backend.programming.learning.system.core.service.domain.implement.review;

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

    @Transactional(readOnly = true)
    public void deleteReviewById(UUID reviewId) {
        Review review = getReview(reviewId);
        reviewRepository.deleteReviewById(reviewId);
        log.info("Review with id: {} deleted successfully", reviewId);
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