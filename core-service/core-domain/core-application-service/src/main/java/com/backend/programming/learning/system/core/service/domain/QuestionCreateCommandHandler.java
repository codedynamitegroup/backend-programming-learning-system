package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.mapper.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.create.QuestionCreatedMessagePublisher;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class QuestionCreateCommandHandler {
    private final QuestionCreateHelper questionCreateHelper;
    private final QuestionDataMapper questionDataMapper;

    public QuestionCreateCommandHandler(QuestionCreateHelper questionCreateHelper,
                                        QuestionDataMapper questionDataMapper) {
        this.questionCreateHelper = questionCreateHelper;
        this.questionDataMapper = questionDataMapper;
    }

    @Transactional
    public CreateQuestionResponse createQuestion(CreateQuestionCommand createQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = questionCreateHelper.persistQuestion(createQuestionCommand);

        log.info("Question created with id: {}", questionCreatedEvent.getQuestion().getId().getValue());

//        questionCreatedMessagePublisher.publish(questionCreatedEvent);

        return questionDataMapper.questionToCreateQuestionResponse(questionCreatedEvent.getQuestion(),
                "Question created successfully");
    }
}