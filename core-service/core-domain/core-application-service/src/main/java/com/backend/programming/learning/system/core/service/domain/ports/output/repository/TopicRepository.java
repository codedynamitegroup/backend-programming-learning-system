package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;

import java.util.Optional;

public interface TopicRepository {
    Topic saveTopic(Topic topic);
    Optional<Topic> findByID(TopicId topicId);
}
