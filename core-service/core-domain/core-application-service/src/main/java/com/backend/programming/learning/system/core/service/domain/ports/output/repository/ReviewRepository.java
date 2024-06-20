package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReviewRepository {
    Review saveReview(Review review);
    Optional<Review> findByCertificateCourseIdAndCreatedBy(UUID certificateCourseId, UUID createdBy);

    Page<Review> findAllByCertificateCourseId(
            UUID certificateCourseId, Integer pageNo, Integer pageSize);

    Optional<Review> findById(UUID reviewId);

    void deleteReviewById(UUID reviewId);

    Float getAvgRatingOfAllReviewsByCertificateCourseId(UUID certificateCourseId);

//    List<Review> findByCertificateCourseIdAndCreatedById(UUID certificateCourseId, UUID createdBy);
    Integer countNumOfReviewsByCertificateCourseIdAndRating(UUID certificateCourseId, Integer rating);
}
