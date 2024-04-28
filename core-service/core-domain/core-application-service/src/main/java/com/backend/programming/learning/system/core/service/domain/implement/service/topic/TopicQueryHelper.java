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
    private final UserRepository userRepository;
    private final TopicProgrammingLanguageRepository topicProgrammingLanguageRepository;

    public TopicQueryHelper(TopicRepository topicRepository,
                            UserRepository userRepository,
                            TopicProgrammingLanguageRepository topicProgrammingLanguageRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.topicProgrammingLanguageRepository = topicProgrammingLanguageRepository;
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
        User createdBy = getUser(topicResult.get().getCreatedBy().getId().getValue());
        User updatedBy = getUser(topicResult.get().getUpdatedBy().getId().getValue());

        Topic topicWithProgrammingLanguages = topicResult.get();
        topicWithProgrammingLanguages.setCreatedBy(createdBy);
        topicWithProgrammingLanguages.setUpdatedBy(updatedBy);

        List<TopicProgrammingLanguage> topicProgrammingLanguages = getAllTopicProgrammingLanguagesForTopic(topicId);

        List<ProgrammingLanguage> programmingLanguages = topicProgrammingLanguages.stream()
                .map(TopicProgrammingLanguage::getProgrammingLanguage)
                .toList();
        topicWithProgrammingLanguages.setProgrammingLanguages(programmingLanguages);

        log.info("Topic queried with id: {}", topicWithProgrammingLanguages.getId().getValue());
        return topicWithProgrammingLanguages;
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    private List<TopicProgrammingLanguage> getAllTopicProgrammingLanguagesForTopic(UUID topicId) {
        List<TopicProgrammingLanguage> topicProgrammingLanguages = topicProgrammingLanguageRepository
                .findAllTopicProgrammingLanguagesByTopicId(new TopicId(topicId));

        log.info("All programming languages queried for topic with id: {}", topicId);
        return topicProgrammingLanguages;
    }

    @Transactional(readOnly = true)
    public Page<Topic> queryAllTopics(
            Integer pageNo, Integer pageSize, Boolean fetchAll
    ) {
        return topicRepository.findAll(pageNo, pageSize, fetchAll);
    }
}





















