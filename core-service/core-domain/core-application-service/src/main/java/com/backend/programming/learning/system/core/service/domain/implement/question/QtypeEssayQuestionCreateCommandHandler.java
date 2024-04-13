package com.backend.programming.learning.system.core.service.domain.implement.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QtypeEssayQuestionCreateCommandHandler {
    private final QtypeEssayQuestionCreateHelper qtypeEssayQuestionCreateHelper;
    private final QuestionDataMapper questionDataMapper;


    public QtypeEssayQuestionCreateCommandHandler(QtypeEssayQuestionCreateHelper qtypeEssayQuestionCreateHelper,
                                                  QuestionDataMapper questionDataMapper) {
        this.qtypeEssayQuestionCreateHelper = qtypeEssayQuestionCreateHelper;
        this.questionDataMapper = questionDataMapper;
    }

    public CreateQuestionResponse createQtypeEssayQuestion(CreateQtypeEssayQuestionCommand createQtypeEssayQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = qtypeEssayQuestionCreateHelper.persistQtypeEssayQuestion(createQtypeEssayQuestionCommand);

        return questionDataMapper.questionToCreateQuestionResponse(questionCreatedEvent.getQuestion(),
                "Qtype Essay Question created successfully");
    }
}
