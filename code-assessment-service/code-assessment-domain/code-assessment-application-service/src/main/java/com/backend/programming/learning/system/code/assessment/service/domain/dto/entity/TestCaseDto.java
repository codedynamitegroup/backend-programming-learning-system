package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.UUID;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class TestCaseDto {
    @NotNull(message = "inputData must not be null")
    private final String inputData;

    @NotNull(message = "outputData must not be null")
    private final String outputData;

    @NotNull(message = "isSample must not be null")
    private final boolean isSample;

    @Positive(message = "score must be positive")
    private final Double score;

    private final UUID id;
}
