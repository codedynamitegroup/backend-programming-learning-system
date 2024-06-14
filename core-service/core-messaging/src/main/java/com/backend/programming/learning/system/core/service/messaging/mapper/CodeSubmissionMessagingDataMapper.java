package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.core.service.domain.dto.message.CodeSubmissionUpdateRequest;
import com.backend.programming.learning.system.kafka.code.assessment.code.submission.avro.model.CodeSubmissionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.code.assessment.code.submission.avro.model.CopyState;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class CodeSubmissionMessagingDataMapper {
    public CodeSubmissionUpdateRequest codeSubmissionUpdateRequestAvroModelToCodeSubmissionUpdateRequest(CodeSubmissionUpdateRequestAvroModel avroModel) {
        return CodeSubmissionUpdateRequest.builder()
                .id(avroModel.getId())
                .codeSubmissionId(avroModel.getCodeSubmisisonId())
                .codeQuestionId(avroModel.getCodeQuestionId())
                .userId(avroModel.getUserId())
                .programmingLanguageId(avroModel.getProgrammingLanguageId())
                .bodyCode(avroModel.getBodyCode())
                .grade(avroModel.getGrade())
                .pass(avroModel.getPass())
                .createdAt(avroModel.getCreatedAt().atZone(ZoneId.of("UTC")))
                .copyState(avroModel.getCopyState().name())
                .cerCourseId(avroModel.getCerCourseId())
                .contestId(avroModel.getContestId())
                .build();
    }
}
