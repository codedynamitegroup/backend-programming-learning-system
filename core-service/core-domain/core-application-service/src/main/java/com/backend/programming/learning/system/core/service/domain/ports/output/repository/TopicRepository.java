package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface TopicRepository {
    Topic saveTopic(Topic topic);
    Optional<Topic> findById(TopicId topicId);
    Page<Topic> findAll(Integer page, Integer size, Boolean fetchAll);
    void deleteTopicById(TopicId topicId);
    int updateTopic(Topic topic);
}
