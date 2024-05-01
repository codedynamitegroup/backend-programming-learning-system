package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.testcase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateTestCaseCommand {
    private final String inputData;

    private final String outputData;

    private final boolean isSample;

    @Positive(message = "score must be positive")
    private final Double score;

    @NotNull(message = "id must not be null")
    private final UUID id;
}
