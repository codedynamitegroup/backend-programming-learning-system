package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.codequestion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CreateCodeQuestionCommand {
    @NotNull(message = "questionId must not be null")
    private final UUID questionId;

    private final String dslTemplate;
    @NotNull(message = "name must not be null")
    private final String name;
    @NotNull(message = "problemStatement must not be null")
    private final String problemStatement;
    @NotNull(message = "inputFormat must not be null")
    private final String inputFormat;
    @NotNull(message = "outputFormat must not be null")
    private final String outputFormat;
    @NotNull(message = "constraints must not be null")
    private final String constraints;
    @NotNull(message = "maxGrade must not be null")
    private final Float maxGrade;
}
