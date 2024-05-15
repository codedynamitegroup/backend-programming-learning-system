package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CreateCodeQuestionCommand {
    @NotNull(message = "questionId must not be null")
    private final UUID questionId;

    @NotNull(message = "userId must not be null")
    private final UUID userId;

    private final String dslTemplate;
    @NotNull(message = "name must not be null")
    private final String name;
    @NotNull(message = "problemStatement must not be null")
    private final String problemStatement;
    private final String inputFormat;
    private final String outputFormat;
    private final String constraints;
    @NotNull(message = "maxGrade must not be null")
    private final Float maxGrade;
    @NotNull(message = "difficulty must not be null")
    private final QuestionDifficulty difficulty;

    @Setter
    private Boolean isPublic;

    private final List<UUID> tagIds;
}
