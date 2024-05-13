package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.review.mapper.ReviewDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.mapper.TopicDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.topic.repository.TopicJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CertificateCourseDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;
    private final TopicDataAccessMapper topicDataAccessMapper;

    public CertificateCourseDataAccessMapper(UserDataAccessMapper userDataAccessMapper,
                                             TopicDataAccessMapper topicDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
        this.topicDataAccessMapper = topicDataAccessMapper;
    }

    public CertificateCourseEntity certificateCourseToCertificateCourseEntity(CertificateCourse certificateCourse) {
        TopicEntity topic = topicDataAccessMapper.topicToTopicEntity(certificateCourse.getTopic());

        return CertificateCourseEntity.builder()
                .id(certificateCourse.getId().getValue())
                .name(certificateCourse.getName())
                .description(certificateCourse.getDescription())
                .skillLevel(certificateCourse.getSkillLevel())
                .avgRating(certificateCourse.getAvgRating())
                .topic(topic)
                .startTime(certificateCourse.getStartTime())
                .endTime(certificateCourse.getEndTime())
                .numOfStudents(certificateCourse.getNumOfStudents())
                .numOfQuestions(certificateCourse.getNumOfQuestions())
                .createdBy(userDataAccessMapper.userToUserEntityHideSensitiveData(certificateCourse.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userToUserEntityHideSensitiveData(certificateCourse.getUpdatedBy()))
                .createdAt(certificateCourse.getCreatedAt())
                .updatedAt(certificateCourse.getUpdatedAt())
                .build();
    }

    public CertificateCourse certificateCourseEntityToCertificateCourse(
            CertificateCourseEntity certificateCourseEntity) {
        Topic topic = topicDataAccessMapper.topicEntityToTopic(certificateCourseEntity.getTopic());

        return CertificateCourse.builder()
                .id(new CertificateCourseId(certificateCourseEntity.getId()))
                .name(certificateCourseEntity.getName())
                .description(certificateCourseEntity.getDescription())
                .skillLevel(certificateCourseEntity.getSkillLevel())
                .avgRating(certificateCourseEntity.getAvgRating())
                .topic(topic)
                .startTime(certificateCourseEntity.getStartTime())
                .endTime(certificateCourseEntity.getEndTime())
                .numOfStudents(certificateCourseEntity.getNumOfStudents())
                .numOfQuestions(certificateCourseEntity.getNumOfQuestions())
                .createdBy(userDataAccessMapper.userEntityToUserHideSensitiveData(certificateCourseEntity.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userEntityToUserHideSensitiveData(certificateCourseEntity.getUpdatedBy()))
                .createdAt(certificateCourseEntity.getCreatedAt())
                .updatedAt(certificateCourseEntity.getUpdatedAt())
                .build();
    }

}
