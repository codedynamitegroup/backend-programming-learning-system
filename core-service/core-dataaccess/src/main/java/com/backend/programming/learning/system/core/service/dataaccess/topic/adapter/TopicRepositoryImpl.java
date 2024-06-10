package com.backend.programming.learning.system.core.service.dataaccess.topic.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.topic.mapper.TopicDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.topic.repository.TopicJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.TopicRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
                .save(topicDataAccessMapper.topicToTopicEntity(topic)));
    }

    @Override
    public Optional<Topic> findById(TopicId topicId) {
        return topicJpaRepository.findById(topicId.getValue())
                .map(topicDataAccessMapper::topicEntityToTopic);
    }

    @Override
    public Page<Topic> findAll(Integer page, Integer size, Boolean fetchAll) {
        Pageable paging = fetchAll ? Pageable.unpaged() : Pageable.ofSize(size).withPage(page);
        return topicJpaRepository.findAll(paging)
                .map(topicDataAccessMapper::topicEntityToTopic);
    }

    @Override
    public void deleteTopicById(TopicId topicId) {
        topicJpaRepository.deleteById(topicId.getValue());
    }

    @Override
    public List<Topic> findAllTopicsOfRegisteredCertificateCoursesByUserId(UUID userId) {
        return topicJpaRepository.findAllTopicsOfRegisteredCertificateCoursesByUserId(userId)
                .stream()
                .map(topicDataAccessMapper::topicEntityToTopic)
                .toList();
    }
}
