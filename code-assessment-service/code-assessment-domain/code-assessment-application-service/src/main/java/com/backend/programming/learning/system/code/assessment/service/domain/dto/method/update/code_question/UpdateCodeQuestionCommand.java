package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.validator.OneNotNull.OneNotNull;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class UpdateCodeQuestionCommand {
    @Setter
    @NotNull(message = "codeQuestionId must not be null")
    @JsonIgnore
    private UUID codeQuestionId;

    @NotNull(message = "userId must not be null")
    private UUID userId;
    private final String name;
    private final String problemStatement;
    private final String inputFormat;
    private final String outputFormat;
    private final String constraints;
    private final Float maxGrade;
    private final QuestionDifficulty difficulty;
    private Boolean isPublic;

}
