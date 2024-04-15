package com.backend.programming.learning.system.core.service.domain.implement.question.method.create;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.entity.User;
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
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final QuestionDataMapper questionDataMapper;


    public QuestionCreateHelper(CoreDomainService coreDomainService,
                                QuestionRepository questionRepository,
                                OrganizationRepository organizationRepository,
                                UserRepository userRepository,
                                QuestionDataMapper questionDataMapper) {
        this.coreDomainService = coreDomainService;
        this.questionRepository = questionRepository;
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
        this.questionDataMapper = questionDataMapper;
    }

    // Create and save question
    @Transactional
    public QuestionCreatedEvent persistQuestion(CreateQuestionCommand createQuestionCommand) {
        User createdBy =  getUser(createQuestionCommand.getCreatedBy());
        User updatedBy = getUser(createQuestionCommand.getUpdatedBy());
        Organization organization = getOrganization(createQuestionCommand.getOrganizationId());

        Question question = questionDataMapper.createQuestionCommandToQuestion(createQuestionCommand, organization, createdBy, updatedBy);
        QuestionCreatedEvent event = coreDomainService.createQuestion(question);
        saveQuestion(question);

        log.info("Question created with id: {}", event.getQuestion().getId().getValue());

        return event;
    }

    // Check if user exists
    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    // Check if organization exists
    private Organization getOrganization(UUID organizationId) {
        Optional<Organization> organization = organizationRepository.findOrganization(organizationId);
        if (organization.isEmpty()) {
            log.warn("Organization with id: {} not found", organizationId);
            throw new CoreDomainException("Could not find organization with id: " + organizationId);
        }
        return organization.get();
    }

    // Save question to database
    private void saveQuestion(Question question) {
        Question savedQuestion = questionRepository.saveQuestion(question);

        if (savedQuestion == null) {
            log.error("Could not save question");

            throw new CoreDomainException("Could not save question");
        }
        log.info("Question saved with id: {}", savedQuestion.getId().getValue());
    }

}





















