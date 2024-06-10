package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TopicRepository {
    Topic saveTopic(Topic topic);
    Optional<Topic> findById(TopicId topicId);
    Page<Topic> findAll(Integer page, Integer size, Boolean fetchAll);
    void deleteTopicById(TopicId topicId);
    List<Topic> findAllTopicsOfRegisteredCertificateCoursesByUserId(UUID userId);
}
