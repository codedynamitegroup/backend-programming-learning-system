package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.core.service.domain.dto.message.CodeQuestionsUpdateRequest;
import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdatePayload;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateResponseAvroModel;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CopyState;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CodeQuestionsMessagingDataMapper {
    public CodeQuestionUpdateResponseAvroModel
            codeQuestionsUpdatePayloadToCodeQuestionUpdateResponseAvroModel(CodeQuestionsUpdatePayload payload){
        return CodeQuestionUpdateResponseAvroModel.newBuilder()
                .setId(UUID.fromString(payload.getId()))
                .setCodeQuestionId(UUID.fromString(payload.getCodeQuestionId()))
                .setSagaId(UUID.fromString(payload.getSagaId()))
                .setQuestionId(UUID.fromString(payload.getQuestionId()))
                .setProblemStatement(payload.getProblemStatement())
                .setInputFormat(payload.getInputFormat())
                .setOutputFormat(payload.getOutputFormat())
                .setConstraints(payload.getConstraints())
                .setCopyState(CopyState.valueOf(payload.getState()))
                .setFailureMessages(payload.getFailureMessages())
                .build();
    }
    public CodeQuestionsUpdateRequest
        codeQuestionUpdateRequestAvroModelToCodeQuestionsUpdateRequest(CodeQuestionUpdateRequestAvroModel model){
        return CodeQuestionsUpdateRequest.builder()
                .id(model.getId().toString())
                .codeQuestionId(model.getQuestionId().toString())
                .sagaId(model.getSagaId().toString())
                .questionId(model.getQuestionId().toString())
                .problemStatement(model.getProblemStatement())
                .inputFormat(model.getInputFormat())
                .outputFormat(model.getOutputFormat())
                .constraints(model.getConstraints())
                .state(model.getCopyState().toString())
                .build();
    }
}