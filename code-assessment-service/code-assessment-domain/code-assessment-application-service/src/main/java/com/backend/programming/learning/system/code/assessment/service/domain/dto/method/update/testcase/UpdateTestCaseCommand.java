package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.testcase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateTestCaseCommand {
    private final String inputData;

    private final String outputData;

    private final Boolean isSample;

    @Positive(message = "score must be positive")
    private final Double score;

    @NotNull(message = "id must not be null")
    private final UUID id;
}
