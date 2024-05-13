package com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.mapper.ProgrammingLanguageDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.repository.ProgrammingLanguageJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.mapper.TopicDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.topic.repository.TopicJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.entity.TopicProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.TopicProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.exception.ProgrammingLanguageNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TopicProgrammingLanguageDataAccessMapper {
    private final TopicDataAccessMapper topicDataAccessMapper;
    private final ProgrammingLanguageDataAccessMapper programmingLanguageDataAccessMapper;

    public TopicProgrammingLanguageDataAccessMapper(TopicDataAccessMapper topicDataAccessMapper,
                                                    ProgrammingLanguageDataAccessMapper programmingLanguageDataAccessMapper) {
        this.topicDataAccessMapper = topicDataAccessMapper;
        this.programmingLanguageDataAccessMapper = programmingLanguageDataAccessMapper;
    }

    public TopicProgrammingLanguageEntity topicProgrammingLanguageToTopicProgrammingLanguageEntity(
            TopicProgrammingLanguage topicProgrammingLanguage) {
        TopicEntity topic = topicDataAccessMapper.topicToTopicEntity(topicProgrammingLanguage.getTopic());
        ProgrammingLanguageEntity programmingLanguage = programmingLanguageDataAccessMapper
                .programmingLanguageToProgrammingLanguageEntity(topicProgrammingLanguage.getProgrammingLanguage());

        return TopicProgrammingLanguageEntity.builder()
                .id(topicProgrammingLanguage.getId().getValue())
                .topic(topic)
                .programmingLanguage(programmingLanguage)
                .build();
    }

    public TopicProgrammingLanguage topicProgrammingLanguageEntityToTopicProgrammingLanguage(
            TopicProgrammingLanguageEntity topicProgrammingLanguageEntity) {
        Topic topic = topicDataAccessMapper.topicEntityToTopic(topicProgrammingLanguageEntity.getTopic());
        ProgrammingLanguage programmingLanguage = programmingLanguageDataAccessMapper
                .programmingLanguageEntityToProgrammingLanguage(topicProgrammingLanguageEntity.getProgrammingLanguage());
        return TopicProgrammingLanguage.builder()
                .id(new TopicProgrammingLanguageId(topicProgrammingLanguageEntity.getId()))
                .topic(topic)
                .programmingLanguage(programmingLanguage)
                .build();
    }

    public List<TopicProgrammingLanguage> topicProgrammingLanguageEntityListToTopicProgrammingLanguageList(
            List<TopicProgrammingLanguageEntity> topicProgrammingLanguageEntities) {
        return topicProgrammingLanguageEntities.stream()
                .map(this::topicProgrammingLanguageEntityToTopicProgrammingLanguage)
                .toList();
    }

    public List<TopicProgrammingLanguageEntity> topicProgrammingLanguagesToTopicProgrammingLanguageEntities(
            List<TopicProgrammingLanguage> topicProgrammingLanguages) {
        return topicProgrammingLanguages.stream()
                .map(this::topicProgrammingLanguageToTopicProgrammingLanguageEntity)
                .toList();
    }

    public List<TopicProgrammingLanguage> topicProgrammingLanguageEntitiesToTopicProgrammingLanguages(
            List<TopicProgrammingLanguageEntity> topicProgrammingLanguageEntities) {
        return topicProgrammingLanguageEntities.stream()
                .map(this::topicProgrammingLanguageEntityToTopicProgrammingLanguage)
                .toList();
    }
}
