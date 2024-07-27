package com.backend.programming.learning.system.core.service.domain.dto.method.create.question;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CreateQtypeMultichoiceQuestionCommand extends CreateQuestionCommand{
    @NotNull(message = "Single is required")
    private final Boolean single;

    private final Boolean shuffleAnswers;

    @NotNull(message = "Answer is required")
    private final String correctFeedback;

    private final String partiallyCorrectFeedback;

    @NotNull(message = "Incorrect feedback is required")
    private final String incorrectFeedback;

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
            String generalFeedback,
            @NotNull(message = "Default mark is required") @DecimalMin(value = "0.0", message = "Default mark must be greater than or equal 0") @Digits(integer = 5, fraction = 2, message = "Default mark must have up to 5 digits and 2 decimals") BigDecimal defaultMark,
            @NotNull(message = "Question type is required") String qType,
            @NotNull(message = "Answers is required") List<AnswerOfQuestion> answers,
            UUID questionBankCategoryId,
            Boolean isOrgQuestionBank,
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
                answers,
                questionBankCategoryId,
                isOrgQuestionBank);
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
