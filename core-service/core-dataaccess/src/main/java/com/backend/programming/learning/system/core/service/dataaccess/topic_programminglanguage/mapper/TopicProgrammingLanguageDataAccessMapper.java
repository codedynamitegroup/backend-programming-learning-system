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
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TopicProgrammingLanguageDataAccessMapper {

    private final TopicJpaRepository topicJpaRepository;
    private final ProgrammingLanguageJpaRepository programmingLanguageJpaRepository;
    private final TopicDataAccessMapper topicDataAccessMapper;
    private final ProgrammingLanguageDataAccessMapper programmingLanguageDataAccessMapper;

    public TopicProgrammingLanguageDataAccessMapper(TopicJpaRepository topicJpaRepository,
                                                    ProgrammingLanguageJpaRepository programmingLanguageJpaRepository,
                                                    TopicDataAccessMapper topicDataAccessMapper,
                                                    ProgrammingLanguageDataAccessMapper programmingLanguageDataAccessMapper) {
        this.topicJpaRepository = topicJpaRepository;
        this.programmingLanguageJpaRepository = programmingLanguageJpaRepository;
        this.topicDataAccessMapper = topicDataAccessMapper;
        this.programmingLanguageDataAccessMapper = programmingLanguageDataAccessMapper;
    }

    public TopicProgrammingLanguageEntity topicProgrammingLanguageToTopicProgrammingLanguageEntity(
            TopicProgrammingLanguage topicProgrammingLanguage) {
        TopicEntity topic = topicJpaRepository
                .findById(topicProgrammingLanguage.getTopic().getId().getValue())
                .orElseThrow(() -> new TopicNotFoundException("Topic with id: " +
                        topicProgrammingLanguage.getTopic().getId().getValue() + " could not be found!")
                );

        ProgrammingLanguageEntity programmingLanguage = programmingLanguageJpaRepository
                .findById(topicProgrammingLanguage.getProgrammingLanguage().getId().getValue())
                .orElseThrow(() -> new ProgrammingLanguageNotFoundException("Programming language with id: " +
                        topicProgrammingLanguage.getProgrammingLanguage().getId().getValue() + " could not be found!")
                );

        return TopicProgrammingLanguageEntity.builder()
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
}
