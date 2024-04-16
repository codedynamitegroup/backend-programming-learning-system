package com.backend.programming.learning.system.core.service.dataaccess.review.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper.CertificateCourseDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.review.mapper.ReviewDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.review.repository.ReviewJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Page<Review> findAllByCertificateCourseId(UUID certificateCourseId, Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return reviewJpaRepository.findAllByCertificateCourseId(certificateCourseId, paging)
                .map(reviewDataAccessMapper::reviewEntityToReview);
    }

    @Override
    public Optional<Review> findById(UUID reviewId) {
        return reviewJpaRepository.findById(reviewId)
                .map(reviewDataAccessMapper::reviewEntityToReview);
    }

    @Override
    public void deleteReviewById(UUID reviewId) {
        reviewJpaRepository.deleteById(reviewId);
    }
}
