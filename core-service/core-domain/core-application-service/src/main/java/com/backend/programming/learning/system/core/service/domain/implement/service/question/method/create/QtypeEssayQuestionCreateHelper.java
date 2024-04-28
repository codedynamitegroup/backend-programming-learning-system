package com.backend.programming.learning.system.core.service.domain.implement.service.question.method.create;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeEssayQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeEssayQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QtypeEssayQuestionCreateHelper {
    private final QtypeEssayQuestionRepository qtypeEssayQuestionRepository;
    private final QtypeEssayQuestionDataMapper qtypeEssayQuestionDataMapper;
    private final QuestionCreateHelper questionCreateHelper;
    private final CoreDomainService coreDomainService;

    public QtypeEssayQuestionCreateHelper(QtypeEssayQuestionRepository qtypeEssayQuestionRepository,
                                          QtypeEssayQuestionDataMapper qtypeEssayQuestionDataMapper,
                                          QuestionCreateHelper questionCreateHelper,
                                          CoreDomainService coreDomainService) {
        this.qtypeEssayQuestionRepository = qtypeEssayQuestionRepository;
        this.qtypeEssayQuestionDataMapper = qtypeEssayQuestionDataMapper;
        this.questionCreateHelper = questionCreateHelper;
        this.coreDomainService = coreDomainService;
    }

    public QuestionCreatedEvent persistQtypeEssayQuestion(CreateQtypeEssayQuestionCommand createQtypeEssayQuestionCommand) {
        Question createdQuestion = questionCreateHelper.persistQuestion(createQtypeEssayQuestionCommand);
        QtypeEssayQuestion qtypeEssayQuestion = qtypeEssayQuestionDataMapper
                .createQtypeEssayQuestionCommandToQtypeEssayQuestion(createQtypeEssayQuestionCommand, createdQuestion);

        // init QtypeEssayQuestion
        QuestionCreatedEvent questionCreatedEvent = coreDomainService.createQtypeEssayQuestion(createdQuestion, qtypeEssayQuestion);
        qtypeEssayQuestionRepository.saveQtypeEssayQuestion(qtypeEssayQuestion);

        log.info("Qtype Essay Question created with id: {}", qtypeEssayQuestion.getId().getValue());

        return questionCreatedEvent;
    }

}
