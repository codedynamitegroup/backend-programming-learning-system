package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.review.entity.ReviewEntity;
import com.backend.programming.learning.system.core.service.dataaccess.review.mapper.ReviewDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.repository.TopicJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CertificateCourseDataAccessMapper {
    private final UserJpaRepository userJpaRepository;
    private final ReviewDataAccessMapper reviewDataAccessMapper;
    private final ChapterDataAccessMapper chapterDataAccessMapper;

    public CertificateCourseDataAccessMapper(UserJpaRepository userJpaRepository,
                                             ReviewDataAccessMapper reviewDataAccessMapper,
                                             ChapterDataAccessMapper chapterDataAccessMapper) {
        this.userJpaRepository = userJpaRepository;
        this.reviewDataAccessMapper = reviewDataAccessMapper;
        this.chapterDataAccessMapper = chapterDataAccessMapper;
    }

    public CertificateCourseEntity certificateCourseToCertificateCourseEntity(CertificateCourse certificateCourse) {
        UserEntity createdBy = userJpaRepository
                .findById(certificateCourse.getCreatedBy().getValue())
                .orElseThrow(() -> new UserNotFoundException("User with id: " +
                        certificateCourse.getCreatedBy().getValue() + " could not be found!")
                );
        UserEntity updatedBy = userJpaRepository
                .findById(certificateCourse.getUpdatedBy().getValue())
                .orElseThrow(() -> new UserNotFoundException("User with id: " +
                        certificateCourse.getUpdatedBy().getValue() + " could not be found!")
                );
        List<ReviewEntity> reviews = certificateCourse.getReviews() != null ?
                certificateCourse.getReviews().stream()
                .map(reviewDataAccessMapper::reviewToReviewEntity)
                .toList() : null;

        List<ChapterEntity> chapters = certificateCourse.getChapters() != null ?
                certificateCourse.getChapters().stream()
                .map(chapterDataAccessMapper::chapterToChapterEntity)
                .toList() : null;

        return CertificateCourseEntity.builder()
                .id(certificateCourse.getId().getValue())
                .name(certificateCourse.getName())
                .description(certificateCourse.getDescription())
                .skillLevel(certificateCourse.getSkillLevel())
                .avgRating(certificateCourse.getAvgRating())
                .reviews(reviews)
                .chapters(chapters)
                .startTime(certificateCourse.getStartTime())
                .endTime(certificateCourse.getEndTime())
                .isDeleted(certificateCourse.getDeleted())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(certificateCourse.getCreatedAt())
                .updatedAt(certificateCourse.getUpdatedAt())
                .build();
    }

    public CertificateCourse certificateCourseEntityToCertificateCourse(
            CertificateCourseEntity certificateCourseEntity) {
        List<Review> reviews = certificateCourseEntity.getReviews() != null ?
                certificateCourseEntity.getReviews().stream()
                .map(reviewDataAccessMapper::reviewEntityToReview)
                .toList() : null;
        List<Chapter> chapters = certificateCourseEntity.getChapters() != null ?
                certificateCourseEntity.getChapters().stream()
                .map(chapterDataAccessMapper::chapterEntityToChapter)
                .toList() : null;

        return CertificateCourse.builder()
                .id(new CertificateCourseId(certificateCourseEntity.getId()))
                .name(certificateCourseEntity.getName())
                .description(certificateCourseEntity.getDescription())
                .skillLevel(certificateCourseEntity.getSkillLevel())
                .avgRating(certificateCourseEntity.getAvgRating())
                .reviews(reviews)
                .chapters(chapters)
                .startTime(certificateCourseEntity.getStartTime())
                .endTime(certificateCourseEntity.getEndTime())
                .isDeleted(certificateCourseEntity.getIsDeleted())
                .createdBy(new UserId(certificateCourseEntity.getCreatedBy().getId()))
                .updatedBy(new UserId(certificateCourseEntity.getUpdatedBy().getId()))
                .createdAt(certificateCourseEntity.getCreatedAt())
                .updatedAt(certificateCourseEntity.getUpdatedAt())
                .build();
    }

}
