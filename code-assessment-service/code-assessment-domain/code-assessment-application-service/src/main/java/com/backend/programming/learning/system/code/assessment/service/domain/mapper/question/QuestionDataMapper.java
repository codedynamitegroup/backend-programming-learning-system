package com.backend.programming.learning.system.code.assessment.service.domain.mapper.question;


import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.QuestionRequest;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class QuestionDataMapper {
    public CodeQuestion questionRequestToCodeQuestion(QuestionRequest request, User user){
        return CodeQuestion.builder()
                .codeQuestionId(new CodeQuestionId(request.getQtypeId()))
                .questionId(new QuestionId(UUID.fromString(request.getId())))
                .name(request.getName())
                .userId(user.getId())
                .orgId(request.getOrganizationId() == null? null: UUID.fromString(request.getOrganizationId()))
                .dslTemplate("")
                .problemStatement(request.getQuestionText())
                .inputFormat(request.getInputFormat())
                .outputFormat(request.getOutputFormat())
                .constraints(request.getConstraint())
                .copyState(CopyState.CREATED)
                .isPublic(request.getIsPublic())
                .difficulty(QuestionDifficulty.valueOf(request.getDifficulty()))
                .maxGrade(request.getDefaultMark().toBigInteger().floatValue())
                .allowImport(request.getAllowImport())
                .isQuestionBank(request.getIsQuestionBank())
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .build();
    }

    public QuestionEventPayload questionRequestToQuestionEventPayload(QuestionRequest questionRequest, CopyState copyState) {
        return QuestionEventPayload.builder()
                .id(questionRequest.getId())
                .sagaId(questionRequest.getSagaId())
                .organizationId(questionRequest.getOrganizationId())
                .createdBy(questionRequest.getCreatedBy())
                .updatedBy(questionRequest.getUpdatedBy())
                .difficulty(questionRequest.getDifficulty())
                .name(questionRequest.getName())
                .questionText(questionRequest.getQuestionText())
                .generalFeedback(questionRequest.getGeneralFeedback())
                .defaultMark(questionRequest.getDefaultMark())
                .qType(questionRequest.getQType())
                .copyState(copyState)
                .build();
    }
}
