package com.backend.programming.learning.system.core.service.domain.dto.method.create.question;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
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
            @NotNull(message = "Organization ID is required") UUID organizationId,
            @NotNull(message = "Created by is required") UUID createdBy,
            @NotNull(message = "Updated by is required") UUID updatedBy,
            @NotNull(message = "Difficulty by is required") String difficulty,
            @NotNull(message = "Name is required") String name,
            @NotNull(message = "Question text is required") String questionText,
            @NotNull(message = "General feedback is required") String generalFeedback,
            @NotNull(message = "Default mark is required") @DecimalMin(value = "0.0", inclusive = false, message = "Default mark must be greater than 0") @Digits(integer = 5, fraction = 2, message = "Default mark must have up to 5 digits and 2 decimals") BigDecimal defaultMark,
            @NotNull(message = "Question type is required") String qType,
            @NotNull(message = "Answers is required") List<AnswerOfQuestion> answers,
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
                qType,
                answers);
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
