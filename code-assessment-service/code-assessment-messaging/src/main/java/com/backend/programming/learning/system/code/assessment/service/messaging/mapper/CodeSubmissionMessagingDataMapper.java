package com.backend.programming.learning.system.code.assessment.service.messaging.mapper;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_submission_update_outbox.CodeSubmissionUpdatePayload;
import com.backend.programming.learning.system.kafka.code.assessment.code.submission.avro.model.CodeSubmissionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.code.assessment.code.submission.avro.model.CopyState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class CodeSubmissionMessagingDataMapper {

    public CodeSubmissionUpdateRequestAvroModel codeSubmissionUpdatePayloadToCodeSubmissionUpdateRequestAvroModel(String sagaId, CodeSubmissionUpdatePayload payload) {
//        log.info("payload {}" , payload.toString());
        return CodeSubmissionUpdateRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(UUID.fromString(sagaId))
                .setCodeSubmisisonId(UUID.fromString(payload.getId()))
                .setProgrammingLanguageId(UUID.fromString(payload.getProgrammingLanguageId()))
                .setBodyCode(payload.getBodyCode())
                .setCodeQuestionId(UUID.fromString(payload.getCodeQuestionId()))
                .setUserId(UUID.fromString(payload.getUserId()))
                .setGrade(payload.getGrade() == null? null: payload.getGrade())
                .setCopyState(CopyState.valueOf(payload.getCopyState()))
                .setPass(payload.getPass())
                .setCreatedAt(payload.getCreatedAt().toInstant())
                .build();
    }
}
