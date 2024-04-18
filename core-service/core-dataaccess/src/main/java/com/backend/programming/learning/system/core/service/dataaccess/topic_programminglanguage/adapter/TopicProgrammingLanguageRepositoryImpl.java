package com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.mapper.TopicProgrammingLanguageDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.repository.TopicProgrammingLanguageJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.TopicProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.TopicProgrammingLanguageRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<TopicProgrammingLanguage> findByTopicIdAndProgrammingLanguageId(TopicId topicId, ProgrammingLanguageId programmingLanguageId) {
        return topicProgrammingLanguageJpaRepository
                .findByTopicIdAndProgrammingLanguageId(topicId.getValue(), programmingLanguageId.getValue())
                .map(topicProgrammingLanguageDataAccessMapper::topicProgrammingLanguageEntityToTopicProgrammingLanguage);
    }

    @Override
    public void deleteAllTopicProgrammingLanguagesByTopicId(TopicId topicId) {
        topicProgrammingLanguageJpaRepository.deleteAllByTopicId(topicId.getValue());
    }
}
