package com.backend.programming.learning.system.core.service.dataaccess.topic.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.entity.TopicProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class TopicDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;

    public TopicDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public TopicEntity topicToTopicEntity(Topic topic) {
        UserEntity createdBy = userDataAccessMapper.userToUserEntityHideSensitiveData(topic.getCreatedBy());
        UserEntity updatedBy = userDataAccessMapper.userToUserEntityHideSensitiveData(topic.getUpdatedBy());

        List<TopicProgrammingLanguageEntity> topicProgrammingLanguageEntities = new ArrayList<>();
        for (ProgrammingLanguage programmingLanguage : topic.getProgrammingLanguages()) {
            topicProgrammingLanguageEntities.add(
                    TopicProgrammingLanguageEntity.builder()
                            .id(UUID.randomUUID())
                            .topic(TopicEntity.builder().id(topic.getId().getValue()).build())
                            .programmingLanguage
                                    (ProgrammingLanguageEntity.builder().id(programmingLanguage.getId().getValue()).build())
                            .build()
            );
        }

        return TopicEntity.builder()
                .id(topic.getId().getValue())
                .name(topic.getName())
                .description(topic.getDescription())
                .thumbnailUrl(topic.getThumbnailUrl())
                .topicProgrammingLanguages(topicProgrammingLanguageEntities)
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(topic.getCreatedAt())
                .updatedAt(topic.getUpdatedAt())
                .build();
    }

    public Topic topicEntityToTopic(TopicEntity topicEntity) {
        User createdBy = userDataAccessMapper.userEntityToUserHideSensitiveData(topicEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUserHideSensitiveData(topicEntity.getUpdatedBy());

        List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();
        for (TopicProgrammingLanguageEntity topicProgrammingLanguageEntity : topicEntity.getTopicProgrammingLanguages()) {
            programmingLanguages.add(
                    ProgrammingLanguage.builder()
                            .id(new ProgrammingLanguageId(topicProgrammingLanguageEntity.getId()))
                            .name(topicProgrammingLanguageEntity.getProgrammingLanguage().getName())
                            .compilerApiId(topicProgrammingLanguageEntity.getProgrammingLanguage().getCompilerApiId())
                            .timeLimit(topicProgrammingLanguageEntity.getProgrammingLanguage().getTimeLimit())
                            .memoryLimit(topicProgrammingLanguageEntity.getProgrammingLanguage().getMemoryLimit())
                            .build()
            );
        }

        return Topic.builder()
                .id(new TopicId(topicEntity.getId()))
                .name(topicEntity.getName())
                .description(topicEntity.getDescription())
                .thumbnailUrl(topicEntity.getThumbnailUrl())
                .programmingLanguages(programmingLanguages)
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(topicEntity.getCreatedAt())
                .updatedAt(topicEntity.getUpdatedAt())
                .build();
    }
}
