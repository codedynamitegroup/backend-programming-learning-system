package com.backend.programming.learning.system.core.service.domain.dto.create.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
public class CreateQtypeCodeQuestionCommand extends CreateQuestionCommand {
    @NotNull
    private final String dslTemplate;

    public CreateQtypeCodeQuestionCommand(@NotNull(message = "Organization ID is required") UUID organizationId, @NotNull(message = "Created by is required") UUID createdBy, @NotNull(message = "Updated by is required") String difficulty, @NotNull(message = "Name is required") String name, @NotNull(message = "Question text is required") String questionText, @NotNull(message = "General feedback is required") String generalFeedback, @NotNull(message = "Default mark is required") BigDecimal defaultMark, @NotNull(message = "Question type is required") String qType, Boolean caseSensitive, Integer single, Integer shuffleAnswers, String correctFeedback, String partiallyCorrectFeedback, String incorrectFeedback, String answerNumbering, Integer showNumCorrect, String showStandardInstructions, String responseFormat, Integer responseRequired, Integer responseFieldLines, Integer minWordLimit, Integer maxWordLimit, Integer attachments, Integer attachmentsRequired, String graderInfo, Integer graderInfoFormat, String responseTemplate, Integer maxBytes, String fileTypesList, String dslTemplate1) {
        super(organizationId, createdBy, difficulty, name, questionText, generalFeedback, defaultMark, qType, caseSensitive, single, shuffleAnswers, correctFeedback, partiallyCorrectFeedback, incorrectFeedback, answerNumbering, showNumCorrect, showStandardInstructions, responseFormat, responseRequired, responseFieldLines, minWordLimit, maxWordLimit, attachments, attachmentsRequired, graderInfo, graderInfoFormat, responseTemplate, maxBytes, fileTypesList);
        this.dslTemplate = dslTemplate1;
    }
}
