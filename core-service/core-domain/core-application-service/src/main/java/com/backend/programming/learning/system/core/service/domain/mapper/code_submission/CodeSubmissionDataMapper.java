package com.backend.programming.learning.system.core.service.domain.mapper.code_submission;

import com.backend.programming.learning.system.core.service.domain.dto.message.CodeSubmissionUpdateRequest;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.codesubmission.CodeSubmissionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.domain.valueobject.*;
import com.backend.programming.learning.system.domain.valueobject.QtypeCodeQuestionId;
import org.springframework.stereotype.Component;

@Component
public class CodeSubmissionDataMapper {
    public CodeSubmission codeSubmissionResponseEntityToCodeSubmission(CodeSubmissionResponseEntity codeSubmissionResponseEntity) {
        return CodeSubmission.builder()
                .id(new CodeSubmissionId(codeSubmissionResponseEntity.getCodeSubmissionId()))
                .codeQuestionId(new QtypeCodeQuestionId(codeSubmissionResponseEntity.getCodeQuestionId()))
                .userId(new UserId(codeSubmissionResponseEntity.getUserId()))
                .programmingLanguageId(new ProgrammingLanguageId(codeSubmissionResponseEntity.getProgrammingLanguageId()))
                .sourceCode(codeSubmissionResponseEntity.getSourceCode())
                .grade(codeSubmissionResponseEntity.getGrade())
                .pass(codeSubmissionResponseEntity.getPass())
                .createdAt(codeSubmissionResponseEntity.getCreatedAt())
                .build();
    }

   public CodeSubmissionResponseEntity codeSubmissionToCodeSubmissionResponseEntity(CodeSubmission codeSubmission) {
        return CodeSubmissionResponseEntity.builder()
                .codeSubmissionId(codeSubmission.getId().getValue())
                .userId(codeSubmission.getUserId().getValue())
                .codeQuestionId(codeSubmission.getCodeQuestionId().getValue())
                .programmingLanguageId(codeSubmission.getProgrammingLanguageId().getValue())
                .sourceCode(codeSubmission.getSourceCode())
                .grade(codeSubmission.getGrade())
                .pass(codeSubmission.getPass())
                .createdAt(codeSubmission.getCreatedAt())
                .build();
    }

    public CodeSubmission CodeSubmissionUpdateRequestToCodeSubmission(CodeSubmissionUpdateRequest request) {
        return CodeSubmission.builder()
                .id(new CodeSubmissionId(request.getCodeSubmissionId()))
                .userId(new UserId(request.getUserId()))
                .codeQuestionId(new QtypeCodeQuestionId(request.getCodeQuestionId()))
                .programmingLanguageId(new ProgrammingLanguageId(request.getProgrammingLanguageId()))
                .sourceCode(request.getBodyCode())
                .grade(request.getGrade())
                .createdAt(request.getCreatedAt())
                .pass(request.getPass())
                .build();
    }
}
