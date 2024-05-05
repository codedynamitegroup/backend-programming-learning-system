package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetCodeSubmissionsByUserIdCommand {
    @NotNull(message = "userId must not be null")
    UUID userId;

    @NotNull(message = "codeQuestionId must not be null")
    UUID codeQuestionId;
}
