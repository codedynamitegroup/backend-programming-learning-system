package com.backend.programming.learning.system.core.service.dataaccess.review.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.review.entity.ReviewEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ReviewId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class ReviewDataAccessMapper {

    private final CertificateCourseJpaRepository certificateCourseJpaRepository;
    private final UserJpaRepository userJpaRepository;

    public ReviewDataAccessMapper(CertificateCourseJpaRepository certificateCourseJpaRepository,
                                  UserJpaRepository userJpaRepository) {
        this.certificateCourseJpaRepository = certificateCourseJpaRepository;
        this.userJpaRepository = userJpaRepository;
    }

    public ReviewEntity reviewToReviewEntity(Review review) {
        CertificateCourseEntity certificateCourse = certificateCourseJpaRepository
                .findById(review.getCertificateCourseId().getValue())
                .orElseThrow();
        UserEntity createdBy = userJpaRepository
                .findById(review.getCreatedBy().getValue())
                .orElseThrow();
        UserEntity updatedBy = userJpaRepository
                .findById(review.getUpdatedBy().getValue())
                .orElseThrow();

        return ReviewEntity.builder()
                .id(review.getId().getValue())
                .rating(review.getRating())
                .content(review.getContent())
                .certificateCourse(certificateCourse)
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

    public Review reviewEntityToReview(ReviewEntity reviewEntity) {
        return Review.builder()
                .id(new ReviewId(reviewEntity.getId()))
                .certificateCourseId(new CertificateCourseId(reviewEntity.getCertificateCourse().getId()))
                .rating(reviewEntity.getRating())
                .content(reviewEntity.getContent())
                .createdBy(new UserId(reviewEntity.getCreatedBy().getId()))
                .updatedBy(new UserId(reviewEntity.getUpdatedBy().getId()))
                .createdAt(reviewEntity.getCreatedAt())
                .updatedAt(reviewEntity.getUpdatedAt())
                .build();
    }
}
