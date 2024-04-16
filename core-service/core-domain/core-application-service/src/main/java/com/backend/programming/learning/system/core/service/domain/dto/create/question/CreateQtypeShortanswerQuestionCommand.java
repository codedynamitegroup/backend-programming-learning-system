package com.backend.programming.learning.system.core.service.domain.dto.create.question;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
public class CreateQtypeShortanswerQuestionCommand extends  CreateQuestionCommand{
    @NotNull
    private final Boolean caseSensitive;


    public CreateQtypeShortanswerQuestionCommand(@NotNull(message = "Organization ID is required") UUID organizationId,
                                                 @NotNull(message = "Created by is required") UUID createdBy,
                                                 @NotNull(message = "Updated by is required") UUID updatedBy,
                                                 @NotNull(message = "Difficulty by is required") String difficulty,
                                                 @NotNull(message = "Name is required") String name,
                                                 @NotNull(message = "Question text is required") String questionText,
                                                 @NotNull(message = "General feedback is required") String generalFeedback,
                                                 @NotNull(message = "Default mark is required") BigDecimal defaultMark,
                                                 @NotNull(message = "Question type is required") String qType,
                                                 Boolean caseSensitive) {
        super(organizationId, createdBy, updatedBy, difficulty, name, questionText, generalFeedback, defaultMark, qType);
        this.caseSensitive = caseSensitive;
    }
}
