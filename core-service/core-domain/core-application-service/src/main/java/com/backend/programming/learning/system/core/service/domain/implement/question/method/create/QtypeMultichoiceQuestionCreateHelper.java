package com.backend.programming.learning.system.core.service.domain.implement.question.method.create;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeMultichoiceQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeMultichoiceQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QtypeMultichoiceQuestionCreateHelper {
    private final QtypeMultichoiceQuestionDataMapper qtypeMultichoiceQuestionDataMapper;
    private final QuestionCreateHelper questionCreateHelper;
    private final CoreDomainService coreDomainService;
    private final QtypeMultichoiceQuestionRepository qtypeMultichoiceQuestionRepository;

    public QtypeMultichoiceQuestionCreateHelper(QtypeMultichoiceQuestionDataMapper qtypeMultichoiceQuestionDataMapper,
                                                QuestionCreateHelper questionCreateHelper,
                                                CoreDomainService coreDomainService,
                                                QtypeMultichoiceQuestionRepository qtypeMultichoiceQuestionRepository) {
        this.qtypeMultichoiceQuestionDataMapper = qtypeMultichoiceQuestionDataMapper;
        this.questionCreateHelper = questionCreateHelper;
        this.coreDomainService = coreDomainService;
        this.qtypeMultichoiceQuestionRepository = qtypeMultichoiceQuestionRepository;
    }

    public QuestionCreatedEvent persistQtypeMultichoiceQuestion(CreateQtypeMultichoiceQuestionCommand createQtypeMultichoiceQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = questionCreateHelper.persistQuestion(createQtypeMultichoiceQuestionCommand);
        QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion = qtypeMultichoiceQuestionDataMapper
                .createQuestionCommandToQtypeMultiChoiceQuestion(createQtypeMultichoiceQuestionCommand,
                        questionCreatedEvent.getQuestion().getId());

        // init QtypeMultiChoiceQuestion
        coreDomainService.createQtypeMultipleChoiceQuestion(qtypeMultiChoiceQuestion);
        qtypeMultichoiceQuestionRepository.saveQtypeMultipleChoiceQuestion(qtypeMultiChoiceQuestion);

        log.info("Qtype Multi Choice Question created with id: {}", qtypeMultiChoiceQuestion.getQuestionId().getValue());
        return questionCreatedEvent;
    }
}