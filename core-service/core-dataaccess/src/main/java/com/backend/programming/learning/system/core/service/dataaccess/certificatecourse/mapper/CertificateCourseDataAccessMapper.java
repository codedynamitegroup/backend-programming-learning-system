package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.repository.TopicJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class CertificateCourseDataAccessMapper {
    private final UserJpaRepository userJpaRepository;
    private final TopicJpaRepository topicJpaRepository;

    public CertificateCourseDataAccessMapper(UserJpaRepository userJpaRepository,
                                             TopicJpaRepository topicJpaRepository) {
        this.userJpaRepository = userJpaRepository;
        this.topicJpaRepository = topicJpaRepository;
    }

    public CertificateCourseEntity certificateCourseToCertificateCourseEntity(CertificateCourse certificateCourse) {
        TopicEntity topic = topicJpaRepository
                .findById(certificateCourse.getTopicId().getValue())
                .orElseThrow();
        UserEntity createdBy = userJpaRepository
                .findById(certificateCourse.getCreatedBy().getValue())
                .orElseThrow();
        UserEntity updatedBy = userJpaRepository
                .findById(certificateCourse.getUpdatedBy().getValue())
                .orElseThrow();

        return CertificateCourseEntity.builder()
                .id(certificateCourse.getId().getValue())
                .name(certificateCourse.getName())
                .description(certificateCourse.getDescription())
                .skillLevel(certificateCourse.getSkillLevel())
                .avgRating(certificateCourse.getAvgRating())
                .topic(topic)
                .reviews(null)
                .chapters(null)
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
        return CertificateCourse.builder()
                .id(new CertificateCourseId(certificateCourseEntity.getId()))
                .name(certificateCourseEntity.getName())
                .description(certificateCourseEntity.getDescription())
                .skillLevel(certificateCourseEntity.getSkillLevel())
                .avgRating(certificateCourseEntity.getAvgRating())
                .topicId(new TopicId(certificateCourseEntity.getTopic().getId()))
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
