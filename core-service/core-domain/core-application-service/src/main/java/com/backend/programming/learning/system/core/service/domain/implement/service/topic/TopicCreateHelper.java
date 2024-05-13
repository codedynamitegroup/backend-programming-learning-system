package com.backend.programming.learning.system.core.service.domain.implement.service.topic;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.topic.TopicDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
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
    private final ProgrammingLanguageRepository programmingLanguageRepository;
    private final TopicProgrammingLanguageRepository topicProgrammingLanguageRepository;
    private final TopicDataMapper topicDataMapper;

    public TopicCreateHelper(CoreDomainService coreDomainService,
                             TopicRepository topicRepository,
                             UserRepository userRepository,
                             ProgrammingLanguageRepository programmingLanguageRepository,
                             TopicDataMapper topicDataMapper,
                             TopicProgrammingLanguageRepository topicProgrammingLanguageRepository) {
        this.coreDomainService = coreDomainService;
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.topicDataMapper = topicDataMapper;
        this.topicProgrammingLanguageRepository = topicProgrammingLanguageRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Transactional
    public Topic persistTopic(CreateTopicCommand createTopicCommand) {
        checkUser(createTopicCommand.getCreatedBy());
        checkUser(createTopicCommand.getUpdatedBy());

        Topic topic = topicDataMapper.
                createTopicCommandToTopic(createTopicCommand);
        coreDomainService.createTopic(topic);
        Topic topicResult = saveTopic(topic);

        for (UUID programmingLanguageId : createTopicCommand.getProgrammingLanguageIds()) {
            ProgrammingLanguage programmingLanguage = getProgrammingLanguage(programmingLanguageId);
            TopicProgrammingLanguage topicProgrammingLanguage =
                    TopicProgrammingLanguage.builder()
                            .id(new TopicProgrammingLanguageId(UUID.randomUUID()))
                            .topic(topicResult)
                            .programmingLanguage(programmingLanguage)
                            .build();
            saveTopicProgrammingLanguage(topicProgrammingLanguage);
        }

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

    private ProgrammingLanguage getProgrammingLanguage(UUID programmingLanguageId) {
        Optional<ProgrammingLanguage> programmingLanguage = programmingLanguageRepository.
                findById(new ProgrammingLanguageId(programmingLanguageId));
        if (programmingLanguage.isEmpty()) {
            log.warn("Programming language with id: {} not found", programmingLanguageId);
            throw new UserNotFoundException("Could not find programming language with id: " + programmingLanguageId);
        }
        return programmingLanguage.get();
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

    private TopicProgrammingLanguage saveTopicProgrammingLanguage(TopicProgrammingLanguage topicProgrammingLanguage) {
        TopicProgrammingLanguage savedTopicProgrammingLanguage = topicProgrammingLanguageRepository
                .saveTopicProgrammingLanguage(topicProgrammingLanguage);

        if (savedTopicProgrammingLanguage == null) {
            log.error("Could not save topic programming language");

            throw new CoreDomainException("Could not save topic programming language");
        }
        log.info("Topic programming language saved with id: {}", savedTopicProgrammingLanguage.getId().getValue());
        return savedTopicProgrammingLanguage;
    }
}





















