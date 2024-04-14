package com.backend.programming.learning.system.code.assessment.service.domain;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionCreatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.CodeQuestionDataMaper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class CodeQuestionCreateCommandHandler {
    private final CodeQuestionCreateHelper codeQuestionCreateHelper;
    private final CodeQuestionDataMaper codeQuestionDataMaper;

    public CodeQuestionCreateCommandHandler
            (CodeQuestionCreateHelper codeQuestionCreateHelper, CodeQuestionDataMaper codeQuestionDataMaper) {

        this.codeQuestionCreateHelper = codeQuestionCreateHelper;
        this.codeQuestionDataMaper = codeQuestionDataMaper;
    }

    public CreateCodeQuestionResponse createCodeQuestion(CreateCodeQuestionCommand command){
        CodeQuestionCreatedEvent codeQuestionCreatedEvent
                = codeQuestionCreateHelper.persistCodeQuestion(command);
        //publish something if u want
        return codeQuestionDataMaper
                .codeQuestionToCreateCodeQuestionReponse
                        (codeQuestionCreatedEvent.getCodeQuestion()
                                , "Code question created successfully");

    }

}
