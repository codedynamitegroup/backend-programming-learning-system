package com.backend.programming.learning.system.core.service.domain.implement.service.topic;

import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.ContestNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.TopicProgrammingLanguageRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.TopicRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class TopicQueryHelper {
    private final TopicRepository topicRepository;

    public TopicQueryHelper(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Transactional(readOnly = true)
    public Topic queryTopicById(UUID topicId) {
        Optional<Topic> topicResult =
                topicRepository.findById(new TopicId(topicId));
        if (topicResult.isEmpty()) {
            log.warn("Could not find topic with id: {}",
                    topicId);
            throw new TopicNotFoundException("Could not find topic with id: " +
                    topicId);
        }

        Topic topic = topicResult.get();
        log.info("Topic queried with id: {}", topic.getId().getValue());
        return topic;
    }

    @Transactional(readOnly = true)
    public Page<Topic> queryAllTopics(
            Integer pageNo, Integer pageSize, Boolean fetchAll
    ) {
        return topicRepository.findAll(pageNo, pageSize, fetchAll);
    }

}





















