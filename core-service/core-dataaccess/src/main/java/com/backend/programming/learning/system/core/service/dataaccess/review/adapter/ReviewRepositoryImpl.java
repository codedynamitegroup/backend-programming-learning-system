package com.backend.programming.learning.system.core.service.dataaccess.review.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper.CertificateCourseDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.review.mapper.ReviewDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.review.repository.ReviewJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
import org.springframework.stereotype.Component;

@Component
public class ReviewRepositoryImpl implements ReviewRepository {
    private final ReviewJpaRepository reviewJpaRepository;
    private final ReviewDataAccessMapper reviewDataAccessMapper;

    public ReviewRepositoryImpl(ReviewJpaRepository reviewJpaRepository,
                               ReviewDataAccessMapper reviewDataAccessMapper) {
        this.reviewJpaRepository = reviewJpaRepository;
        this.reviewDataAccessMapper = reviewDataAccessMapper;
    }

    @Override
    public Review saveReview(Review review) {
        return reviewDataAccessMapper.reviewEntityToReview(reviewJpaRepository
                .save(reviewDataAccessMapper
                        .reviewToReviewEntity(review)));
    }
}
