package com.backend.programming.learning.system.core.service.domain.implement.topic;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.review.ReviewDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.topic.TopicDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.TopicRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class TopicCreateHelper {
    private final CoreDomainService coreDomainService;
    private final TopicRepository topicRepository;
    private final UserRepository userRepository;
    private final TopicDataMapper topicDataMapper;

    public TopicCreateHelper(CoreDomainService coreDomainService,
                             TopicRepository topicRepository,
                             UserRepository userRepository,
                             TopicDataMapper topicDataMapper) {
        this.coreDomainService = coreDomainService;
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.topicDataMapper = topicDataMapper;
    }

    @Transactional
    public Topic persistTopic(CreateTopicCommand createTopicCommand) {
        checkUser(createTopicCommand.getCreatedBy());
        checkUser(createTopicCommand.getUpdatedBy());

        Topic topic = topicDataMapper.
                createTopicCommandToTopic(createTopicCommand);
        coreDomainService.createTopic(topic);
        Topic topicResult = saveTopic(topic);

        log.info("Topic created with id: {}", topicResult.getId().getValue());
        return topicResult;
    }

    private void checkUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
    }

    private Topic saveTopic(Topic topic) {
        Topic savedTopic = topicRepository
                .saveTopic(topic);

        if (savedTopic == null) {
            log.error("Could not save topic");

            throw new CoreDomainException("Could not save topic");
        }
        log.info("Topic saved with id: {}", savedTopic.getId().getValue());
        return savedTopic;
    }
}





















