package com.backend.programming.learning.system.core.service.domain.dto.create.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class CreateQuestionCommand {
    @NotNull(message = "Organization ID is required")
    private final UUID organizationId;
    @NotNull(message = "Created by is required")
    private final UUID createdBy;
    @NotNull(message = "Updated by is required")
    private final String difficulty;
    @NotNull(message = "Name is required")
    private final String name;
    @NotNull(message = "Question text is required")
    private final String questionText;
    @NotNull(message = "General feedback is required")
    private final String generalFeedback;
    @NotNull(message = "Default mark is required")
    private final BigDecimal defaultMark;
    @NotNull(message = "Question type is required")
    private final String qType;
}
