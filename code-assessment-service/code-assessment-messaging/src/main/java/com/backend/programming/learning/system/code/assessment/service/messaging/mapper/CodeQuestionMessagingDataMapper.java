package com.backend.programming.learning.system.code.assessment.service.messaging.mapper;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.CodeQuestionsUpdateResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionsUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdatePayload;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateResponseAvroModel;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CopyState;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component

public class CodeQuestionMessagingDataMapper {
    public CodeQuestionsUpdateResponse
            codeQuestionUpdateResponseAvroModelToCodeQuestionUpdateResponse
            (CodeQuestionUpdateResponseAvroModel model){
        return CodeQuestionsUpdateResponse.builder()
                .id(model.getId())
                .questionId(model.getQuestionId())
                .problemStatement(model.getProblemStatement())
                .inputFormat(model.getInputFormat())
                .outputFormat(model.getOutputFormat())
                .state(com.backend.programming.learning.system.domain.valueobject
                        .CopyState
                        .valueOf(model.getCopyState().toString()))
                .constraints(model.getConstraints())
                .failureMessages(model.getFailureMessages())
                .sagaId(model.getSagaId())
                .build();
    }
    public CodeQuestionUpdateRequestAvroModel
        codeQuestionsUpdatePayloadToCodeQuestionUpdateRequestAvroModel(String sagaId,
                                                                       CodeQuestionsUpdatePayload payload){
        return CodeQuestionUpdateRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(UUID.fromString(sagaId))
                .setCodeQuestionId(UUID.fromString(payload.getId()))
                .setQuestionId(UUID.fromString(payload.getQuestionId()))
                .setProblemStatement(payload.getProblemStatement())
                .setInputFormat(payload.getInputFormat())
                .setOutputFormat(payload.getOutputFormat())
                .setCopyState(CopyState.valueOf(payload.getCopyState()))
                .setConstraints(payload.getConstraints())
                .build();
    }
}
