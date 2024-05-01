package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CreateCodeSubmissionCommand {
    @NotNull
    private UUID codeQuestionId;
    @NotNull
    private UUID userId;
    @NotNull
    private UUID languageId;
    @NotNull
    private String sourceCode;

}
