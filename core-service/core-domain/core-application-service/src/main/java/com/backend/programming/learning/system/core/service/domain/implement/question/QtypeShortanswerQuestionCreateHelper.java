package com.backend.programming.learning.system.core.service.domain.implement.question;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeShortanswerQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeShortanswerQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QtypeShortanswerQuestionCreateHelper {

    private final QuestionCreateHelper questionCreateHelper;
    private final CoreDomainService coreDomainService;
    private final QtypeShortanswerQuestionRepository qtypeShortanswerQuestionRepository;
    private final QtypeShortanswerQuestionDataMapper qtypeShortanswerQuestionDataMapper;

    public QtypeShortanswerQuestionCreateHelper(QuestionCreateHelper questionCreateHelper,
                                                CoreDomainService coreDomainService,
                                                QtypeShortanswerQuestionRepository qtypeShortanswerQuestionRepository,
                                                QtypeShortanswerQuestionDataMapper qtypeShortanswerQuestionDataMapper) {
        this.questionCreateHelper = questionCreateHelper;
        this.coreDomainService = coreDomainService;
        this.qtypeShortanswerQuestionRepository = qtypeShortanswerQuestionRepository;
        this.qtypeShortanswerQuestionDataMapper = qtypeShortanswerQuestionDataMapper;
    }

    public QuestionCreatedEvent persistQtypeShortanswerQuestion(CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = questionCreateHelper.persistQuestion(createQtypeShortanswerQuestionCommand);
        QtypeShortAnswerQuestion qtypeShortAnswerQuestion = qtypeShortanswerQuestionDataMapper
                .createQuestionCommandToQtypeShortAnswerQuestion(createQtypeShortanswerQuestionCommand,
                        questionCreatedEvent.getQuestion().getId());

        // init QtypeShortAnswerQuestion
        coreDomainService.createQtypeShortAnswerQuestion(qtypeShortAnswerQuestion);
        qtypeShortanswerQuestionRepository.saveQtypeShortAnswerQuestion(qtypeShortAnswerQuestion);

        log.info("Qtype Short Answer Question created with id: {}", qtypeShortAnswerQuestion.getQuestionId().getValue());
        return questionCreatedEvent;
    }
}
