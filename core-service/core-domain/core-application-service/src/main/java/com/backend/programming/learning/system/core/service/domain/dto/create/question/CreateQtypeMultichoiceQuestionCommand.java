package com.backend.programming.learning.system.core.service.domain.dto.create.question;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CreateQtypeMultichoiceQuestionCommand extends CreateQuestionCommand{
    @NotNull(message = "Single is required")
    private final Boolean single;

    @NotNull(message = "Shuffle answers is required")
    private final Boolean shuffleAnswers;

    @NotNull(message = "Answer is required")
    private final String correctFeedback;

    @NotNull(message = "Partially correct feedback is required")
    private final String partiallyCorrectFeedback;

    @NotNull(message = "Incorrect feedback is required")
    private final String incorrectFeedback;

    @NotNull(message = "Answer numbering is required")
    private final String answerNumbering;

    @NotNull(message = "Show number correct is required")
    private final Integer showNumCorrect;

    @NotNull(message = "Show standard instructions is required")
    private final String showStandardInstructions;

    public CreateQtypeMultichoiceQuestionCommand(
            @NotNull(message = "Organization ID is required") @Size(min = 36, max = 36, message = "Organization ID of organization must have 36 digits including \"-\" ") UUID organizationId,
            @NotNull(message = "Created by is required") @Size(min = 36, max = 36, message = "User ID of createdBy must have 36 digits including \"-\"") UUID createdBy,
            @NotNull(message = "Updated by is required") @Size(min = 36, max = 36, message = "User ID of updatedBy must have 36 digits including \"-\"") UUID updatedBy,
            @NotNull(message = "Difficulty by is required") String difficulty,
            @NotNull(message = "Name is required") String name,
            @NotNull(message = "Question text is required") String questionText,
            @NotNull(message = "General feedback is required") String generalFeedback,
            @NotNull(message = "Default mark is required") @Size(min = 0, message = "Default mark must be between 0 and your input number") BigDecimal defaultMark,
            @NotNull(message = "Question type is required") String qType,
            Boolean single,
            Boolean shuffleAnswers,
            String correctFeedback,
            String partiallyCorrectFeedback,
            String incorrectFeedback,
            String answerNumbering,
            Integer showNumCorrect,
            String showStandardInstructions) {
        super(organizationId,
                createdBy,
                updatedBy,
                difficulty,
                name,
                questionText,
                generalFeedback,
                defaultMark,
                qType);

        this.single = single;
        this.shuffleAnswers = shuffleAnswers;
        this.correctFeedback = correctFeedback;
        this.partiallyCorrectFeedback = partiallyCorrectFeedback;
        this.incorrectFeedback = incorrectFeedback;
        this.answerNumbering = answerNumbering;
        this.showNumCorrect = showNumCorrect;
        this.showStandardInstructions = showStandardInstructions;
    }
}
