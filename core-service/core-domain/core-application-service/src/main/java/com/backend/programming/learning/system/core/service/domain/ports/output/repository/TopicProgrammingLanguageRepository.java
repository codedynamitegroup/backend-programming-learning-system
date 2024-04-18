package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.TopicProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;

import java.util.List;
import java.util.Optional;

public interface TopicProgrammingLanguageRepository {
    TopicProgrammingLanguage saveTopicProgrammingLanguage(
            TopicProgrammingLanguage topicProgrammingLanguage);

    List<TopicProgrammingLanguage> findAllTopicProgrammingLanguagesByTopicId(
            TopicId topicId);

    Optional<TopicProgrammingLanguage> findByTopicIdAndProgrammingLanguageId(
            TopicId topicId, ProgrammingLanguageId programmingLanguageId);

    void deleteAllTopicProgrammingLanguagesByTopicId(TopicId topicId);
}
