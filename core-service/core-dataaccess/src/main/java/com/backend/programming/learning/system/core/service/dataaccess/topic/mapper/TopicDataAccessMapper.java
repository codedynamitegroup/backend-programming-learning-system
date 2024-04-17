package com.backend.programming.learning.system.core.service.dataaccess.topic.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.mapper.ProgrammingLanguageDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.review.entity.ReviewEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.entity.TopicProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ReviewId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TopicDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;

    public TopicDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public TopicEntity topicToTopicEntity(Topic topic) {
        UserEntity createdBy = userDataAccessMapper.userToUserEntity(topic.getCreatedBy());
        UserEntity updatedBy = userDataAccessMapper.userToUserEntity(topic.getUpdatedBy());

        return TopicEntity.builder()
                .id(topic.getId().getValue())
                .name(topic.getName())
                .description(topic.getDescription())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(topic.getCreatedAt())
                .updatedAt(topic.getUpdatedAt())
                .build();
    }

    public Topic topicEntityToTopic(TopicEntity topicEntity) {
        User createdBy = userDataAccessMapper.userEntityToUser(topicEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUser(topicEntity.getUpdatedBy());

        return Topic.builder()
                .id(new TopicId(topicEntity.getId()))
                .name(topicEntity.getName())
                .description(topicEntity.getDescription())
                .programmingLanguages(new ArrayList<>())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(topicEntity.getCreatedAt())
                .updatedAt(topicEntity.getUpdatedAt())
                .build();
    }
}
