package com.backend.programming.learning.system.core.service.dataaccess.review.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.review.entity.ReviewEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
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
    private final UserDataAccessMapper userDataAccessMapper;

    public ReviewDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public ReviewEntity reviewToReviewEntity(Review review) {
        return ReviewEntity.builder()
                .id(review.getId().getValue())
                .rating(review.getRating())
                .content(review.getContent())
                .certificateCourse(CertificateCourseEntity.builder()
                        .id(review.getCertificateCourseId().getValue())
                        .build())
                .createdBy(UserEntity.builder()
                        .id(review.getCreatedBy().getId().getValue())
                        .build())
                .updatedBy(UserEntity.builder()
                        .id(review.getUpdatedBy().getId().getValue())
                        .build())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

    public Review reviewEntityToReview(ReviewEntity reviewEntity) {
        User createdBy = userDataAccessMapper.userEntityToUserHideSensitiveData(reviewEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUserHideSensitiveData(reviewEntity.getUpdatedBy());

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
