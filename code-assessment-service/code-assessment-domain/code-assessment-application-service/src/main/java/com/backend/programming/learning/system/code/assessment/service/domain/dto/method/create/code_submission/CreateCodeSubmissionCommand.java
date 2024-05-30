package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @NotNull(message = "headCode must not be null")
    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
    message = "headCode must be base64 encoded")
    private String headCode;

    @NotNull(message = "bodyCode must not be null")
    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
            message = "bodyCode must be base64 encoded")
    private String bodyCode;

    @NotNull(message = "tailCode must not be null")
    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
            message = "tailCode must be base64 encoded")
    private String tailCode;

}
