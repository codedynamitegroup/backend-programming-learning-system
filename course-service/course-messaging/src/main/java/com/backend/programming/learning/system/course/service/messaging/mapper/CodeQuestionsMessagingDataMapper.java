package com.backend.programming.learning.system.course.service.messaging.mapper;

import com.backend.programming.learning.system.course.service.domain.dto.messaging.CodeQuestionsUpdateRequest;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateResponseAvroModel;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CopyState;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CodeQuestionsMessagingDataMapper {
    public CodeQuestionsUpdateRequest
        codeQuestionUpdateRequestAvroModelToCodeQuestionsUpdateRequest(CodeQuestionUpdateRequestAvroModel model){
        return CodeQuestionsUpdateRequest.builder()
                .id(model.getId())
                .codeQuestionId(model.getCodeQuestionId())
                .sagaId(model.getSagaId())
                .questionId(model.getQuestionId())
                .problemStatement(model.getProblemStatement())
                .maxGrade(model.getMaxGrade())
                .name(model.getName())
//                .constraints(model.getConstraints())
                .state(model.getCopyState().toString())
                .orgId(model.getOrgId())
                .isPublic(model.getIsPublic())
                .isAllowedToImport(model.getAllowImport())
                .difficulty(model.getDifficulty())
                .categoryBank(model.getCategoryBankId())
                .email(model.getEmail())
                .isQuestionBank(model.getIsQuestionBank())
                .build();
    }
}
