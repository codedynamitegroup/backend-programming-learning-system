package com.backend.programming.learning.system.core.service.domain.ports;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.mapper.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.AuthRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CoreRepository;
import com.backend.programming.learning.system.domain.CoreDomainService;
import com.backend.programming.learning.system.domain.entity.Organization;
import com.backend.programming.learning.system.domain.entity.Question;
import com.backend.programming.learning.system.domain.entity.User;
import com.backend.programming.learning.system.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.domain.exception.CoreDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class QuestionCreateHelper {
    private final CoreDomainService coreDomainService;
    private final CoreRepository coreRepository;
    private final AuthRepository authRepository;
    private final QuestionDataMapper questionDataMapper;

    public QuestionCreateHelper(CoreDomainService coreDomainService,
                                CoreRepository coreRepository,
                                AuthRepository authRepository,
                                QuestionDataMapper questionDataMapper) {
        this.coreDomainService = coreDomainService;
        this.coreRepository = coreRepository;
        this.authRepository = authRepository;
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
        return event;
    }

    private void checkUser(UUID userId) {
        Optional<User> user = authRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new CoreDomainException("Could not find user with id: " + userId);
        }
    }
    private void checkOrganization(UUID organizationId) {
        Optional<Organization> organization = authRepository.findOrganization(organizationId);
        if (organization.isEmpty()) {
            log.warn("Organization with id: {} not found", organizationId);
            throw new CoreDomainException("Could not find organization with id: " + organizationId);
        }
    }

    private Question saveQuestion(Question question) {
        Question savedQuestion = coreRepository.saveQuestion(question);
        if (savedQuestion == null) {
            log.error("Could not save question");

            throw new CoreDomainException("Could not save question");
        }
        log.info("Question saved with id: {}", savedQuestion.getId().getValue());
        return savedQuestion;
    }
}
