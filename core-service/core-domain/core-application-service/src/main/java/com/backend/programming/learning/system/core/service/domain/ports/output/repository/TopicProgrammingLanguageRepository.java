package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.TopicProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;

import java.util.List;

public interface TopicProgrammingLanguageRepository {
    TopicProgrammingLanguage saveTopicProgrammingLanguage(
            TopicProgrammingLanguage topicProgrammingLanguage);

    List<TopicProgrammingLanguage> findAllTopicProgrammingLanguagesByTopicId(
            TopicId topicId);
}
