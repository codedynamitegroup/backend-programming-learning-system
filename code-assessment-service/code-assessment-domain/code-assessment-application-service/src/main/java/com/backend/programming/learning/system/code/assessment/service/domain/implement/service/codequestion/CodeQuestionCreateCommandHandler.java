package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.codequestion;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.codequestion.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.codequestion.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionCreatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.CodeQuestionDataMaper;

import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.message.publisher.codequestion.CodeQuestionCreateMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class CodeQuestionCreateCommandHandler {
    private final CodeQuestionCreateHelper codeQuestionCreateHelper;
    private final CodeQuestionDataMaper codeQuestionDataMaper;
    private final CodeQuestionCreateMessagePublisher codeQuestionCreateMessagePublisher;

    public CodeQuestionCreateCommandHandler
            (CodeQuestionCreateHelper codeQuestionCreateHelper,
             CodeQuestionDataMaper codeQuestionDataMaper,
             CodeQuestionCreateMessagePublisher codeQuestionCreateMessagePublisher) {
        this.codeQuestionCreateHelper = codeQuestionCreateHelper;
        this.codeQuestionDataMaper = codeQuestionDataMaper;
        this.codeQuestionCreateMessagePublisher = codeQuestionCreateMessagePublisher;
    }

    public CreateCodeQuestionResponse createCodeQuestion(CreateCodeQuestionCommand command){
        CodeQuestionCreatedEvent codeQuestionCreatedEvent
                = codeQuestionCreateHelper.persistCodeQuestion(command);
        codeQuestionCreateMessagePublisher.publish(codeQuestionCreatedEvent);
        return codeQuestionDataMaper
                .codeQuestionToCreateCodeQuestionReponse
                        (codeQuestionCreatedEvent.getCodeQuestion()
                                , "Code question created successfully");

    }

}
