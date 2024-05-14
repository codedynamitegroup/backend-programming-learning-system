package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.testcase;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.validator.OneNotNull.OneNotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@OneNotNull(
        fields = {"inputData", "outputData", "isSample", "score"},
        message = "inputData, outputData, isSample or score must not be null"
)
public class UpdateTestCaseCommand {
    private final String inputData;

    private final String outputData;

    private final Boolean isSample;

    @Positive(message = "score must be positive")
    private final Double score;

    @NotNull(message = "id must not be null")
    private final UUID id;
}
