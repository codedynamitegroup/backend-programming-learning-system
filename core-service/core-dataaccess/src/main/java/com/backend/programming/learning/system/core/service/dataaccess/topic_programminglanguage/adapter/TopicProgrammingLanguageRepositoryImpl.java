package com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.mapper.TopicProgrammingLanguageDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.repository.TopicProgrammingLanguageJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.TopicProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.TopicProgrammingLanguageRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public TopicProgrammingLanguage saveTopicProgrammingLanguage(TopicProgrammingLanguage topicProgrammingLanguage) {
        return topicProgrammingLanguageDataAccessMapper.
                topicProgrammingLanguageEntityToTopicProgrammingLanguage(
                topicProgrammingLanguageJpaRepository
                        .save(topicProgrammingLanguageDataAccessMapper
                                .topicProgrammingLanguageToTopicProgrammingLanguageEntity(
                                        topicProgrammingLanguage)));
    }

    @Override
    public List<TopicProgrammingLanguage> findAllTopicProgrammingLanguagesByTopicId(TopicId topicId) {
        return topicProgrammingLanguageDataAccessMapper
                .topicProgrammingLanguageEntityListToTopicProgrammingLanguageList(
                        topicProgrammingLanguageJpaRepository
                                .findAllByTopicId(topicId.getValue()));
    }
}
