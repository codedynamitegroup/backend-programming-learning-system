package com.backend.programming.learning.system.core.service.dataaccess.topic.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TopicDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;

    public TopicDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public TopicEntity topicToTopicEntity(Topic topic) {
        UserEntity createdBy = userDataAccessMapper.userToUserEntityHideSensitiveData(topic.getCreatedBy());
        UserEntity updatedBy = userDataAccessMapper.userToUserEntityHideSensitiveData(topic.getUpdatedBy());

        return TopicEntity.builder()
                .id(topic.getId().getValue())
                .name(topic.getName())
                .description(topic.getDescription())
                .thumbnailUrl(topic.getThumbnailUrl())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(topic.getCreatedAt())
                .updatedAt(topic.getUpdatedAt())
                .build();
    }

    public Topic topicEntityToTopic(TopicEntity topicEntity) {
        User createdBy = userDataAccessMapper.userEntityToUserHideSensitiveData(topicEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUserHideSensitiveData(topicEntity.getUpdatedBy());

        return Topic.builder()
                .id(new TopicId(topicEntity.getId()))
                .name(topicEntity.getName())
                .description(topicEntity.getDescription())
                .thumbnailUrl(topicEntity.getThumbnailUrl())
                .programmingLanguages(new ArrayList<>())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(topicEntity.getCreatedAt())
                .updatedAt(topicEntity.getUpdatedAt())
                .build();
    }
}
