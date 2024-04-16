package com.backend.programming.learning.system.core.service.domain.dto.create.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class CreateQuestionCommand {
    @NotNull(message = "Organization ID is required")
    @Size(min = 36, max = 36, message = "Organization ID of organization must have 36 digits including \"-\" ")
    private final UUID organizationId;

    @NotNull(message = "Created by is required")
    @Size(min = 36, max = 36, message = "User ID of createdBy must have 36 digits including \"-\"")
    private final UUID createdBy;

    @NotNull(message = "Updated by is required")
    @Size(min = 36, max = 36, message = "User ID of updatedBy must have 36 digits including \"-\"")
    private final UUID updatedBy;

    @NotNull(message = "Difficulty by is required")
    private final String difficulty;

    @NotNull(message = "Name is required")
    private final String name;

    @NotNull(message = "Question text is required")
    private final String questionText;

    @NotNull(message = "General feedback is required")
    private final String generalFeedback;

    @NotNull(message = "Default mark is required")
    @Size(min = 0, message = "Default mark must be between 0 and your input number")
    private final BigDecimal defaultMark;

    @NotNull(message = "Question type is required")
    private final String qType;
}
