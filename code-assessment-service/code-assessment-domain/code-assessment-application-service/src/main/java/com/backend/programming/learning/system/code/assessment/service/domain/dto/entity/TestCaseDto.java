package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor(force = true)
public class TestCaseDto {
    @NotNull(message = "inputData must not be null")
    @JsonProperty("inputData")
    private final String inputData;

    @NotNull(message = "outputData must not be null")
    @JsonProperty("outputData")
    private final String outputData;

    @NotNull(message = "isSample must not be null")
    @JsonProperty("isSample")
    private final boolean isSample;

//    @Positive(message = "score must be positive")
    @JsonProperty("score")
    private final Double score;

    @JsonProperty("id")
    private final UUID id;
}
