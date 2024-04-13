package com.backend.programming.learning.system.core.service.domain.dto.create.question;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CreateQtypeMultichoiceQuestionCommand extends CreateQuestionCommand{
    @NotNull
    private final Integer single;
    @NotNull
    private final Integer shuffleAnswers;
    @NotNull
    private final String correctFeedback;
    @NotNull
    private final String partiallyCorrectFeedback;
    @NotNull
    private final String incorrectFeedback;
    @NotNull
    private final String answerNumbering;
    @NotNull
    private final Integer showNumCorrect;
    @NotNull
    private final String showStandardInstructions;

    public CreateQtypeMultichoiceQuestionCommand(@NotNull(message = "Organization ID is required") UUID organizationId,
                                                 @NotNull(message = "Created by is required") UUID createdBy,
                                                 @NotNull(message = "Updated by is required") String difficulty,
                                                 @NotNull(message = "Name is required") String name,
                                                 @NotNull(message = "Question text is required") String questionText,
                                                 @NotNull(message = "General feedback is required") String generalFeedback,
                                                 @NotNull(message = "Default mark is required") BigDecimal defaultMark,
                                                 @NotNull(message = "Question type is required") String qType,
                                                 Integer single,
                                                 Integer shuffleAnswers,
                                                 String correctFeedback,
                                                 String partiallyCorrectFeedback,
                                                 String incorrectFeedback,
                                                 String answerNumbering,
                                                 Integer showNumCorrect,
                                                 String showStandardInstructions) {
        super(organizationId, createdBy, difficulty, name, questionText, generalFeedback, defaultMark, qType);
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
