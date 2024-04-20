package com.backend.programming.learning.system.code.assessment.service.messaging.mapper;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.CodeQuestionUpdateResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionCreatedEvent;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateResponseAvroModel;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CopyState;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component

public class CodeQuestionMessagingDataMapper {
    public CodeQuestionUpdateRequestAvroModel
    codeQuestionCreatedEventToCodeQuestionUpdateRequestAvroModel
            (CodeQuestionCreatedEvent codeQuestionCreatedEvent){

        CodeQuestion codeQuestion = codeQuestionCreatedEvent.getCodeQuestion();
        return CodeQuestionUpdateRequestAvroModel.newBuilder()
                .setId(codeQuestion.getId().getValue())
                .setSagaId(UUID.randomUUID())
                .setQuestionId(codeQuestion.getQuestionId().getValue())
                .setConstraints(codeQuestion.getConstraints())
                .setInputFormat(codeQuestion.getInputFormat())
                .setCopyState(CopyState.valueOf(codeQuestion.getCopyState().toString()))
                .setOutputFormat(codeQuestion.getOutputFormat())
                .setProblemStatement(codeQuestion.getProblemStatement())
                .build();
    }
    public CodeQuestionUpdateResponse
            codeQuestionUpdateResponseAvroModelToCodeQuestionUpdateResponse
            (CodeQuestionUpdateResponseAvroModel model){
        return CodeQuestionUpdateResponse.builder()
                .id(model.getId())
                .questionId(model.getQuestionId())
                .problemStatement(model.getProblemStatement())
                .inputFormat(model.getInputFormat())
                .outputFormat(model.getOutputFormat())
                .state(com.backend.programming.learning.system.domain.valueobject
                        .CopyState
                        .valueOf(model.getCopyState().toString()))
                .constraints(model.getConstraints())
                .build();
    }
}
