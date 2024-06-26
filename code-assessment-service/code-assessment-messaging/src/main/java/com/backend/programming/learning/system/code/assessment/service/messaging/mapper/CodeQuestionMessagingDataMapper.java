package com.backend.programming.learning.system.code.assessment.service.messaging.mapper;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.codequestion.CodeQuestionsUpdateResponse;
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
                .codeQuestionId(model.getCodeQuestionId())
                .questionId(model.getQuestionId())
                .problemStatement(model.getProblemStatement())
                .maxGrade(model.getMaxGrade())
                .name(model.getName())
                .state(com.backend.programming.learning.system.domain.valueobject
                        .CopyState
                        .valueOf(model.getCopyState().toString()))
//                .constraints(model.getConstraints())
                .failureMessages(model.getFailureMessages())
                .sagaId(model.getSagaId())
                .isPublic(model.getIsPublic())
                .allowImport(model.getAllowImport())
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
                .setMaxGrade(payload.getMaxGrade())
                .setName(payload.getName())
                .setIsPublic(payload.getIsPublic())
                .setAllowImport(payload.getAllowImport())
                .setCopyState(CopyState.valueOf(payload.getCopyState()))
//                .setConstraints(payload.getConstraints())
                .build();
    }
}
