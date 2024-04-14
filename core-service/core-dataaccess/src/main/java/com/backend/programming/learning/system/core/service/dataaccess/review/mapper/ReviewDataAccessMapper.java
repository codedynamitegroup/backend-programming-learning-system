package com.backend.programming.learning.system.core.service.dataaccess.review.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.review.entity.ReviewEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ReviewId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class ReviewDataAccessMapper {

    private final CertificateCourseJpaRepository certificateCourseJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;

    public ReviewDataAccessMapper(CertificateCourseJpaRepository certificateCourseJpaRepository,
                                  UserJpaRepository userJpaRepository,
                                  UserDataAccessMapper userDataAccessMapper) {
        this.certificateCourseJpaRepository = certificateCourseJpaRepository;
        this.userJpaRepository = userJpaRepository;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public ReviewEntity reviewToReviewEntity(Review review) {
        CertificateCourseEntity certificateCourse = certificateCourseJpaRepository
                .findById(review.getCertificateCourseId().getValue())
                .orElseThrow(() -> new CertificateCourseNotFoundException("Certificate course with id: " +
                        review.getCertificateCourseId().getValue() + " could not be found!")
                );
        UserEntity createdBy = userJpaRepository
                .findById(review.getCreatedBy().getId().getValue())
                .orElseThrow(() -> new UserNotFoundException("User with id: " +
                        review.getCreatedBy().getId().getValue() + " could not be found!")
                );
        UserEntity updatedBy = userJpaRepository
                .findById(review.getUpdatedBy().getId().getValue())
                .orElseThrow(() -> new UserNotFoundException("User with id: " +
                        review.getUpdatedBy().getId().getValue() + " could not be found!")
                );

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
        User createdBy = userDataAccessMapper.userEntityToUser(reviewEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUser(reviewEntity.getUpdatedBy());

        return Review.builder()
                .id(new ReviewId(reviewEntity.getId()))
                .certificateCourseId(new CertificateCourseId(reviewEntity.getCertificateCourse().getId()))
                .rating(reviewEntity.getRating())
                .content(reviewEntity.getContent())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(reviewEntity.getCreatedAt())
                .updatedAt(reviewEntity.getUpdatedAt())
                .build();
    }
}
