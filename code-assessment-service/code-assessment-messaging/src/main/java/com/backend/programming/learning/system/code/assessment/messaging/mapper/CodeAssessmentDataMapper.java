package com.backend.programming.learning.system.code.assessment.messaging.mapper;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionCreatedEvent;
import com.backend.programming.learning.system.kafka.code.assessment.avro.model.CodeQuestionUpdateRequestAvroModel;
import org.springframework.stereotype.Component;

@Component
public class CodeAssessmentDataMapper {
    public CodeQuestionUpdateRequestAvroModel
    codeQuestionCreatedEventToCodeQuestionUpdateRequestAvroModel
            (CodeQuestionCreatedEvent codeQuestionCreatedEvent){

        CodeQuestion codeQuestion = codeQuestionCreatedEvent.getCodeQuestion();
        return CodeQuestionUpdateRequestAvroModel.newBuilder()
                .setId(codeQuestion.getId().getValue())
                .setQuestionId(codeQuestion.getQuestionId().getValue())
                .setConstraints(codeQuestion.getConstraints())
                .setInputFormat(codeQuestion.getInputFormat())
                .setIsDeleted(codeQuestion.getIsDeleted())
                .setOutputFormat(codeQuestion.getOutputFormat())
                .setProblemStatement(codeQuestion.getProblemStatement())
                .build();
    }
}
