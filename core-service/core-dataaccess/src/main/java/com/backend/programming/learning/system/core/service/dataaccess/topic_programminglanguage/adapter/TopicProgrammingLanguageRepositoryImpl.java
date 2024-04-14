package com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.mapper.TopicProgrammingLanguageDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.repository.TopicProgrammingLanguageJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.TopicProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.TopicProgrammingLanguageRepository;
import org.springframework.stereotype.Component;

@Component
public class TopicProgrammingLanguageRepositoryImpl implements TopicProgrammingLanguageRepository {

    private final TopicProgrammingLanguageJpaRepository topicProgrammingLanguageJpaRepository;
    private final TopicProgrammingLanguageDataAccessMapper topicProgrammingLanguageDataAccessMapper;

    public TopicProgrammingLanguageRepositoryImpl(TopicProgrammingLanguageJpaRepository topicProgrammingLanguageJpaRepository,
                                                  TopicProgrammingLanguageDataAccessMapper topicProgrammingLanguageDataAccessMapper) {
        this.topicProgrammingLanguageJpaRepository = topicProgrammingLanguageJpaRepository;
        this.topicProgrammingLanguageDataAccessMapper = topicProgrammingLanguageDataAccessMapper;
    }

    @Override
    public TopicProgrammingLanguage saveCertificateCourseProgrammingLanguage(
            TopicProgrammingLanguage topicProgrammingLanguage) {
        return topicProgrammingLanguageDataAccessMapper.
                topicProgrammingLanguageEntityToTopicProgrammingLanguage(
                topicProgrammingLanguageJpaRepository
                        .save(topicProgrammingLanguageDataAccessMapper
                                .topicProgrammingLanguageToTopicProgrammingLanguageEntity(
                                        topicProgrammingLanguage)));
    }
}
