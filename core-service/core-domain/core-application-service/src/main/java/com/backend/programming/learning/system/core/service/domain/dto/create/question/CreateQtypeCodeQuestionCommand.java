package com.backend.programming.learning.system.core.service.domain.dto.create.question;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
public class CreateQtypeCodeQuestionCommand extends CreateQuestionCommand {
    @NotNull
    private final String dslTemplate;


    public CreateQtypeCodeQuestionCommand(
            @NotNull(message = "Organization ID is required") UUID organizationId,
            @NotNull(message = "Created by is required") UUID createdBy,
            @NotNull(message = "Updated by is required") UUID updatedBy,
            @NotNull(message = "Difficulty by is required") String difficulty,
            @NotNull(message = "Name is required") String name,
            @NotNull(message = "Question text is required") String questionText,
            @NotNull(message = "General feedback is required") String generalFeedback,
            @NotNull(message = "Default mark is required")
            @DecimalMin(value = "0.0", inclusive = false, message = "Default mark must be greater than 0")
            @Digits(integer = 5, fraction = 2, message = "Default mark must have up to 5 digits and 2 decimals")
            BigDecimal defaultMark,
            @NotNull(message = "Question type is required") String qType, String dslTemplate) {
        super(organizationId,
                createdBy,
                updatedBy,
                difficulty,
                name,
                questionText,
                generalFeedback,
                defaultMark,
                qType);
        this.dslTemplate = dslTemplate;
    }
}
