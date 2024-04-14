package com.backend.programming.learning.system.core.service.dataaccess.topic.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.topic.mapper.TopicDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.topic.repository.TopicJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.TopicRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TopicRepositoryImpl implements TopicRepository {
    private final TopicJpaRepository topicJpaRepository;
    private final TopicDataAccessMapper topicDataAccessMapper;

    public TopicRepositoryImpl(TopicJpaRepository topicJpaRepository,
                               TopicDataAccessMapper topicDataAccessMapper) {
        this.topicJpaRepository = topicJpaRepository;
        this.topicDataAccessMapper = topicDataAccessMapper;
    }

    @Override
    public Topic saveTopic(Topic topic) {
        return topicDataAccessMapper.topicEntityToTopic(topicJpaRepository
                .save(topicDataAccessMapper
                        .topicToTopicEntity(topic)));
    }

    @Override
    public Optional<Topic> findByID(TopicId topicId) {
        return topicJpaRepository.findById(topicId.getValue())
                .map(topicDataAccessMapper::topicEntityToTopic);
    }
}
