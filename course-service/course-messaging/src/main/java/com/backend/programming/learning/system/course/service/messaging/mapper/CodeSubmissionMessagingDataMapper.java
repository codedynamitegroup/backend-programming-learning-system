package com.backend.programming.learning.system.course.service.messaging.mapper;

import com.backend.programming.learning.system.course.service.domain.dto.messaging.CodeSubmissionResultRequest;
import com.backend.programming.learning.system.course.service.domain.outbox.model.code_submission_sender.CodeSubmissionEventPayload;
import com.backend.programming.learning.system.kafka.code.assessment.code.submission.avro.model.CodeSubmissionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.course.code_submission_sender.avro_model.CodeSubmissionSenderRequestAvroModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CodeSubmissionMessagingDataMapper {
    public CodeSubmissionSenderRequestAvroModel payloadToAvroModel(String sagaId, CodeSubmissionEventPayload payload) {
        return CodeSubmissionSenderRequestAvroModel.newBuilder()
                .setSubmissionId(UUID.fromString(payload.getSubmissionId()))
                .setContent(payload.getContent())
                .setSagaId(UUID.fromString(sagaId))
                .setUserId(UUID.fromString(payload.getUserId()))
                .build();
    }

    public CodeSubmissionResultRequest codeSubmissionUpdateRequestAvroModelToCodeSubmissionResultRequest(CodeSubmissionUpdateRequestAvroModel avroModel) {
        return CodeSubmissionResultRequest.builder()
                .codeSubmissionId(avroModel.getCodeSubmisisonId())
                .grade(avroModel.getGrade())
                .result(avroModel.getResult())
                .sagaId(avroModel.getSagaId())
                .passed(avroModel.getPass())
                .build();
    }
}
