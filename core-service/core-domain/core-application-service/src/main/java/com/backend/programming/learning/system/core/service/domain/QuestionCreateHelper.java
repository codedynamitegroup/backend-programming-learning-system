package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class QuestionCreateHelper {
    private final CoreDomainService coreDomainService;
    private final QuestionRepository questionRepository;
    private final QtypeCodeQuestionRepository qtypeCodeQuestionRepository;
    private final QtypeShortanswerQuestionRepository qtypeShortanswerQuestionRepository;
    private final QtypeEssayQuestionRepository qtypeEssayQuestionRepository;
    private final QtypeMultichoiceQuestionRepository qtypeMultichoiceQuestionRepository;
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final QuestionDataMapper questionDataMapper;


    public QuestionCreateHelper(CoreDomainService coreDomainService,
                                QuestionRepository questionRepository,
                                QtypeCodeQuestionRepository qtypeCodeQuestionRepository,
                                QtypeShortanswerQuestionRepository qtypeShortanswerQuestionRepository,
                                QtypeEssayQuestionRepository qtypeEssayQuestionRepository,
                                QtypeMultichoiceQuestionRepository qtypeMultichoiceQuestionRepository,
                                OrganizationRepository organizationRepository,
                                UserRepository userRepository,
                                QuestionDataMapper questionDataMapper) {
        this.coreDomainService = coreDomainService;
        this.questionRepository = questionRepository;
        this.qtypeCodeQuestionRepository = qtypeCodeQuestionRepository;
        this.qtypeShortanswerQuestionRepository = qtypeShortanswerQuestionRepository;
        this.qtypeEssayQuestionRepository = qtypeEssayQuestionRepository;
        this.qtypeMultichoiceQuestionRepository = qtypeMultichoiceQuestionRepository;
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
        this.questionDataMapper = questionDataMapper;
    }

    // Create and save question
    @Transactional
    public QuestionCreatedEvent persistQuestion(CreateQuestionCommand createQuestionCommand) {
        checkUser(createQuestionCommand.getCreatedBy());
        checkOrganization(createQuestionCommand.getOrganizationId());

        Question question = questionDataMapper.createQuestionCommandToQuestion(createQuestionCommand);
        QuestionCreatedEvent event = coreDomainService.createQuestion(question);
        saveQuestion(question);

        log.info("Question created with id: {}", event.getQuestion().getId().getValue());

        return event;
    }

    // Check if user exists
    private void checkUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
    }

    // Check if organization exists
    private void checkOrganization(UUID organizationId) {
        Optional<Organization> organization = organizationRepository.findOrganization(organizationId);
        if (organization.isEmpty()) {
            log.warn("Organization with id: {} not found", organizationId);
            throw new CoreDomainException("Could not find organization with id: " + organizationId);
        }
    }

    // Save question to database
    private Question saveQuestion(Question question) {
        Question savedQuestion = questionRepository.saveQuestion(question);

        if (savedQuestion == null) {
            log.error("Could not save question");

            throw new CoreDomainException("Could not save question");
        }
        log.info("Question saved with id: {}", savedQuestion.getId().getValue());
        return savedQuestion;
    }

}





















