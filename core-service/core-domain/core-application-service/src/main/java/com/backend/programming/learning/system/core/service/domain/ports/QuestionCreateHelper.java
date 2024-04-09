package com.backend.programming.learning.system.core.service.domain.ports;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.mapper.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeCodeQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeShortanswerQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.domain.CoreDomainService;
import com.backend.programming.learning.system.domain.entity.*;
import com.backend.programming.learning.system.domain.event.Question.QuestionCreatedEvent;
import com.backend.programming.learning.system.domain.exception.CoreDomainException;
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
    private final OrganizationRepository organizationRepository;
    private final QuestionDataMapper questionDataMapper;


    public QuestionCreateHelper(CoreDomainService coreDomainService,
                                QuestionRepository questionRepository,
                                QtypeCodeQuestionRepository qtypeCodeQuestionRepository,
                                QtypeShortanswerQuestionRepository qtypeShortanswerQuestionRepository,
                                OrganizationRepository organizationRepository,
                                QuestionDataMapper questionDataMapper) {
        this.coreDomainService = coreDomainService;
        this.questionRepository = questionRepository;
        this.qtypeCodeQuestionRepository = qtypeCodeQuestionRepository;
        this.qtypeShortanswerQuestionRepository = qtypeShortanswerQuestionRepository;
        this.organizationRepository = organizationRepository;
        this.questionDataMapper = questionDataMapper;
    }

    @Transactional
    public QuestionCreatedEvent persistQuestion(CreateQuestionCommand createQuestionCommand) {
        checkUser(createQuestionCommand.getCreatedBy());
        checkOrganization(createQuestionCommand.getOrganizationId());

        Question question = questionDataMapper.createQuestionCommandToQuestion(createQuestionCommand);
        QuestionCreatedEvent event = coreDomainService.createQuestion(question);
        Question questionResult = saveQuestion(question);

        log.info("Question created with id: {}", event.getQuestion().getId().getValue());
        saveQuestionType(createQuestionCommand, questionResult.getId());

        return event;
    }

    private void checkUser(UUID userId) {
        Optional<User> user = organizationRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new CoreDomainException("Could not find user with id: " + userId);
        }
    }

    private void checkOrganization(UUID organizationId) {
        Optional<Organization> organization = organizationRepository.findOrganization(organizationId);
        if (organization.isEmpty()) {
            log.warn("Organization with id: {} not found", organizationId);
            throw new CoreDomainException("Could not find organization with id: " + organizationId);
        }
    }

    private Question saveQuestion(Question question) {
        Question savedQuestion = questionRepository.saveQuestion(question);

        if (savedQuestion == null) {
            log.error("Could not save question");

            throw new CoreDomainException("Could not save question");
        }
        log.info("Question saved with id: {}", savedQuestion.getId().getValue());
        return savedQuestion;
    }

    private void saveQuestionType(CreateQuestionCommand createQuestionCommand, QuestionId questionId) {
        if(createQuestionCommand.getDslTemplate() != null) {
            QtypeCodeQuestion question = questionDataMapper
                    .createQuestionCommandToQtypeCodeQuestion(createQuestionCommand, questionId);
            qtypeCodeQuestionRepository.saveQtypeCodeQuestion(question);
            log.info("Question with id: {} saved with QtypeCodeQuestionRepository", questionId);
        } else if (createQuestionCommand.getCaseSensitive() != null) {
            QtypeShortAnswerQuestion question = questionDataMapper
                    .createQuestionCommandToQtypeShortAnswerQuestion(createQuestionCommand, questionId);
            qtypeShortanswerQuestionRepository.saveQtypeShortAnswerQuestion(question);
            log.info("Question with id: {} saved with QtypeShortAnswerQuestion", questionId);
        }
    }
}
