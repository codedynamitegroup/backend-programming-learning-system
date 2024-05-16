package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class GetMemoryAndTimeRankingCommand {
    @NotNull(message = "codeSubmissionId must not be null")
    UUID codeSubmissionId;
}
