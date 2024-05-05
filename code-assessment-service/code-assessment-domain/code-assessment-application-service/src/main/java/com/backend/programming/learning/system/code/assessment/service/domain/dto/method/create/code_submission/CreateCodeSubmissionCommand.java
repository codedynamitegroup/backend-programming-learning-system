package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CreateCodeSubmissionCommand {
    @NotNull(message = "codeQuestionId must not be null")
    private UUID codeQuestionId;
    @NotNull(message = "userId must not be null")
    private UUID userId;
    @NotNull(message = "languageId must not be null")
    private UUID languageId;
    @NotNull(message = "sourceCode must not be null")
    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
    message = "sourceCode must be base64 encoded")
    private String sourceCode;

}
