package com.backend.programming.learning.system.core.service.domain.implement.service.topic;

import com.backend.programming.learning.system.core.service.domain.dto.method.update.review.UpdateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.topic.UpdateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.ReviewNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicProgrammingLanguageId;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Slf4j
@Component
public class TopicUpdateHelper {
    private final TopicRepository topicRepository;
    private final UserRepository userRepository;
    private final TopicProgrammingLanguageRepository topicProgrammingLanguageRepository;

    public TopicUpdateHelper(TopicRepository topicRepository,
                             UserRepository userRepository,
                             TopicProgrammingLanguageRepository topicProgrammingLanguageRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.topicProgrammingLanguageRepository = topicProgrammingLanguageRepository;
    }

    @Transactional
    public void persistTopic(UpdateTopicCommand updateTopicCommand) {
        Topic topic = getTopic(updateTopicCommand.getTopicId());
        User updatedBy = getUser(updateTopicCommand.getUpdatedBy());

        if (updateTopicCommand.getName() != null) {
            topic.setName(updateTopicCommand.getName());
        }

        if (updateTopicCommand.getDescription() != null) {
            topic.setDescription(updateTopicCommand.getDescription());
        }
        if(Objects.nonNull(updateTopicCommand.getIsSingleProgrammingLanguage())){
            topic.setIsSingleProgrammingLanguage(updateTopicCommand.getIsSingleProgrammingLanguage());
        }
        if(Objects.nonNull(updateTopicCommand.getThumbnailUrl())){
            topic.setThumbnailUrl(updateTopicCommand.getThumbnailUrl());
        }
        topic.setUpdatedBy(updatedBy);
        topic.setUpdatedAt(ZonedDateTime.now(ZoneId.of("UTC")));

        if (updateTopicCommand.getProgrammingLanguageIds() != null) {
            deleteAllTopicProgrammingLanguagesForTopic(topic.getId().getValue());
            List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();
            for (UUID programmingLanguageId : updateTopicCommand.getProgrammingLanguageIds()) {
                programmingLanguages.add(ProgrammingLanguage.builder()
                        .id(new ProgrammingLanguageId(programmingLanguageId))
                        .build());
            }
            topic.setProgrammingLanguages(programmingLanguages);
        }

        updateTopic(topic);
        log.info("Topic updated with id: {}", topic.getId().getValue());
    }

    private Topic getTopic(UUID topicId) {
        Optional<Topic> topic = topicRepository.findById(new TopicId(topicId));
        if (topic.isEmpty()) {
            log.warn("Topic with id: {} not found", topicId);
            throw new ReviewNotFoundException("Could not find topic with id: " + topicId);
        }
        return topic.get();
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    private void deleteAllTopicProgrammingLanguagesForTopic(UUID topicId) {
        topicProgrammingLanguageRepository.deleteAllTopicProgrammingLanguagesByTopicId(new TopicId(topicId));
        log.info("All topic programming languages deleted for topic with id: {}", topicId);
    }

    private void saveTopicProgrammingLanguage(TopicProgrammingLanguage topicProgrammingLanguage) {
        log.info("Saving topic programming language with topicId: {} and programmingLanguageId: {}",
                topicProgrammingLanguage.getTopic().getId().getValue(),
                topicProgrammingLanguage.getProgrammingLanguage().getId().getValue());
        topicProgrammingLanguageRepository.saveTopicProgrammingLanguage(topicProgrammingLanguage);
        log.info("Topic programming language saved with id: {}", topicProgrammingLanguage.getId().getValue());
    }

    private void updateTopic(Topic topic) {
        Topic updatedTopic = topicRepository.saveTopic(topic);

        if (updatedTopic == null) {
            log.error("Could not update topic with id: {}", topic.getId().getValue());

            throw new CoreDomainException("Could not update topic with id: " + topic.getId().getValue());
        }
        log.info("Topic updated with id: {}", topic.getId().getValue());
    }
}





















