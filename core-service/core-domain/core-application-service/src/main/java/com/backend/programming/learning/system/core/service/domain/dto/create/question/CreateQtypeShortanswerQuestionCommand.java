package com.backend.programming.learning.system.core.service.domain.dto.create.question;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
public class CreateQtypeShortanswerQuestionCommand extends  CreateQuestionCommand{
    @NotNull(message = "Case sensitive is required")
    private final Boolean caseSensitive;

    public CreateQtypeShortanswerQuestionCommand(
            @NotNull(message = "Organization ID is required") @Size(min = 36, max = 36, message = "Organization ID of organization must have 36 digits including \"-\" ") UUID organizationId,
            @NotNull(message = "Created by is required") @Size(min = 36, max = 36, message = "User ID of createdBy must have 36 digits including \"-\"") UUID createdBy,
            @NotNull(message = "Updated by is required") @Size(min = 36, max = 36, message = "User ID of updatedBy must have 36 digits including \"-\"") UUID updatedBy,
            @NotNull(message = "Difficulty by is required") String difficulty,
            @NotNull(message = "Name is required") String name,
            @NotNull(message = "Question text is required") String questionText,
            @NotNull(message = "General feedback is required") String generalFeedback,
            @NotNull(message = "Default mark is required") @Size(min = 0, message = "Default mark must be between 0 and your input number") BigDecimal defaultMark,
            @NotNull(message = "Question type is required") String qType, Boolean caseSensitive) {
        super(organizationId,
                createdBy,
                updatedBy,
                difficulty,
                name,
                questionText,
                generalFeedback,
                defaultMark,
                qType);
        this.caseSensitive = caseSensitive;
    }
}
