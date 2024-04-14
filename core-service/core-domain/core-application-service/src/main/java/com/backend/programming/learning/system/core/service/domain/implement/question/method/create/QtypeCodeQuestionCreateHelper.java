package com.backend.programming.learning.system.core.service.domain.implement.question.method.create;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeCodeQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeCodeQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QtypeCodeQuestionCreateHelper {
    private final QtypeCodeQuestionRepository qtypeCodeQuestionRepository;
    private final QtypeCodeQuestionDataMapper qtypeCodeQuestionDataMapper;
    private final QuestionCreateHelper questionCreateHelper;
    private final CoreDomainService coreDomainService;


    public QtypeCodeQuestionCreateHelper(QtypeCodeQuestionRepository qtypeCodeQuestionRepository,
                                         QtypeCodeQuestionDataMapper qtypeCodeQuestionDataMapper,
                                         QuestionCreateHelper questionCreateHelper,
                                         CoreDomainService coreDomainService) {
        this.qtypeCodeQuestionRepository = qtypeCodeQuestionRepository;
        this.qtypeCodeQuestionDataMapper = qtypeCodeQuestionDataMapper;
        this.questionCreateHelper = questionCreateHelper;
        this.coreDomainService = coreDomainService;
    }

    public QuestionCreatedEvent persistQtypeCodeQuestion(CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = questionCreateHelper.persistQuestion(createQtypeCodeQuestionCommand);
        QtypeCodeQuestion qtypeCodeQuestion = qtypeCodeQuestionDataMapper
                .createQuestionCommandToQtypeCodeQuestion(createQtypeCodeQuestionCommand,
                        questionCreatedEvent.getQuestion().getId());

        // init QtypeCodeQuestion
        coreDomainService.createQtypeCodeQuestion(qtypeCodeQuestion);
        qtypeCodeQuestionRepository.saveQtypeCodeQuestion(qtypeCodeQuestion);

        log.info("Qtype Code Question created with id: {}", qtypeCodeQuestion.getQuestionId().getValue());

        return questionCreatedEvent;
    }
}
