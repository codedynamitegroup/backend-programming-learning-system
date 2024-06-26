package com.backend.programming.learning.system.core.service.dataaccess.review.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.review.mapper.ReviewDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.review.repository.ReviewJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
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
    public Optional<Review> findByCertificateCourseIdAndCreatedBy(UUID certificateCourseId, UUID createdBy) {
        return reviewJpaRepository.findByCertificateCourseIdAndCreatedBy(certificateCourseId, createdBy)
                .map(reviewDataAccessMapper::reviewEntityToReview);
    }

    @Override
    public Page<Review> findAllByCertificateCourseId(UUID certificateCourseId, Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("updatedAt").descending());
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

    @Override
    public Float getAvgRatingOfAllReviewsByCertificateCourseId(UUID certificateCourseId) {
        return reviewJpaRepository.getAvgRatingOfAllReviewsByCertificateCourseId(certificateCourseId);
    }

    @Override
    public Integer countNumOfReviewsByCertificateCourseIdAndRating(UUID certificateCourseId, Integer rating) {
        return reviewJpaRepository.countNumOfReviewsByCertificateCourseIdAndRating(certificateCourseId, rating);
    }

    @Override
    public Integer countNumOfReviewsByCertificateCourseId(UUID certificateCourseId) {
        return reviewJpaRepository.countNumOfReviewsByCertificateCourseId(certificateCourseId);
    }

//    @Override
//    public List<Review> findByCertificateCourseIdAndCreatedById(UUID certificateCourseId, UUID createdBy) {
//        return reviewJpaRepository.findByCertificateCourseIdAndCreatedById(certificateCourseId, createdBy)
//                .stream()
//                .map(reviewDataAccessMapper::reviewEntityToReview)
//                .toList();
//    }
}
