package com.backend.programming.learning.system.core.service.domain.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class CreateQuestionCommand {
    @NotNull
    private final UUID organizationId;
    @NotNull
    private final UUID createdBy;
    @NotNull
    private final UUID updatedBy;
    @NotNull
    private final String difficulty;
    @NotNull
    private final String name;
    @NotNull
    private final String questionText;
    @NotNull
    private final String generalFeedback;
    @NotNull
    private final BigDecimal defaultMark;
    @NotNull
    private final String qType;
}
