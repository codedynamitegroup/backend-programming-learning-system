package com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.repository.ProgrammingLanguageJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.repository.TopicJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.entity.TopicProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.TopicProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ProgrammingLanguageNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import org.springframework.stereotype.Component;

@Component
public class TopicProgrammingLanguageDataAccessMapper {

    private final TopicJpaRepository topicJpaRepository;
    private final ProgrammingLanguageJpaRepository programmingLanguageJpaRepository;

    public TopicProgrammingLanguageDataAccessMapper(TopicJpaRepository topicJpaRepository,
                                                    ProgrammingLanguageJpaRepository programmingLanguageJpaRepository) {
        this.topicJpaRepository = topicJpaRepository;
        this.programmingLanguageJpaRepository = programmingLanguageJpaRepository;
    }

    public TopicProgrammingLanguageEntity topicProgrammingLanguageToTopicProgrammingLanguageEntity(
            TopicProgrammingLanguage topicProgrammingLanguage) {
        TopicEntity topic = topicJpaRepository
                .findById(topicProgrammingLanguage.getTopicId().getValue())
                .orElseThrow(() -> new TopicNotFoundException("Topic with id: " +
                        topicProgrammingLanguage.getTopicId().getValue() + " could not be found!")
                );

        ProgrammingLanguageEntity programmingLanguage = programmingLanguageJpaRepository
                .findById(topicProgrammingLanguage.getProgrammingLanguageId().getValue())
                .orElseThrow(() -> new ProgrammingLanguageNotFoundException("Programming language with id: " +
                        topicProgrammingLanguage.getProgrammingLanguageId().getValue() + " could not be found!")
                );

        return TopicProgrammingLanguageEntity.builder()
                .topic(topic)
                .programmingLanguage(programmingLanguage)
                .build();
    }

    public TopicProgrammingLanguage topicProgrammingLanguageEntityToTopicProgrammingLanguage(
            TopicProgrammingLanguageEntity topicProgrammingLanguageEntity) {
        return TopicProgrammingLanguage.builder()
                .topicId(new TopicId(topicProgrammingLanguageEntity.getTopic().getId()))
                .programmingLanguageId(new
                        ProgrammingLanguageId(topicProgrammingLanguageEntity.
                        getProgrammingLanguage().getId()))
                .build();
    }
}
