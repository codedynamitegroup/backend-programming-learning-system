package com.backend.programming.learning.system.core.service.domain.implement.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QtypeMultichoiceQuestionCreateCommandHandler {
    private final QtypeMultichoiceQuestionCreateHelper qtypeMultichoiceQuestionCreateHelper;
    private final QuestionDataMapper questionDataMapper;

    public QtypeMultichoiceQuestionCreateCommandHandler(QtypeMultichoiceQuestionCreateHelper qtypeMultichoiceQuestionCreateHelper, QuestionDataMapper questionDataMapper) {
        this.qtypeMultichoiceQuestionCreateHelper = qtypeMultichoiceQuestionCreateHelper;
        this.questionDataMapper = questionDataMapper;
    }

    public CreateQuestionResponse createQtypeMultichoiceQuestion(CreateQtypeMultichoiceQuestionCommand createQtypeMultichoiceQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = qtypeMultichoiceQuestionCreateHelper.persistQtypeMultichoiceQuestion(createQtypeMultichoiceQuestionCommand);

        return questionDataMapper.questionToCreateQuestionResponse(questionCreatedEvent.getQuestion(),
                "Qtype Multichoice Question created successfully");
    }
}
