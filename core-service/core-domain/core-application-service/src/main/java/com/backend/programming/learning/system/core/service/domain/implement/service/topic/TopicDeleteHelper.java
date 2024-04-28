package com.backend.programming.learning.system.core.service.domain.implement.service.topic;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.exception.ContestNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.TopicRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class TopicDeleteHelper {
    private final TopicRepository topicRepository;

    public TopicDeleteHelper(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Transactional(readOnly = true)
    public void deleteTopicById(UUID topicId) {
        checkTopicExists(topicId);
        topicRepository.deleteTopicById(new TopicId(topicId));
    }

    private void checkTopicExists(UUID topicId) {
        Optional<Topic> topic = topicRepository.findById(new TopicId(topicId));
        if (topic.isEmpty()) {
            log.warn("Could not find topic with id: {}", topicId);
            throw new ContestNotFoundException("Could not find topic with id: " + topicId);
        }
    }
}