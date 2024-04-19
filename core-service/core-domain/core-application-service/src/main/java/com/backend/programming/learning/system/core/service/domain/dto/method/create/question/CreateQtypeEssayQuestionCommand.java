package com.backend.programming.learning.system.core.service.domain.dto.method.create.question;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CreateQtypeEssayQuestionCommand extends CreateQuestionCommand{
    @NotNull(message = "Response format is required")
    private final String responseFormat;

    @NotNull(message = "Response required is required")
    private final Integer responseRequired;

    @NotNull(message = "Response field lines is required")
    private final Integer responseFieldLines;

    @NotNull(message = "Min word limit is required")
    @Size(min = 1, message = "Min word limit must be between 1 and your input number")
    private final Integer minWordLimit;

    @NotNull(message = "Max word limit is required")
    @Size(min = 1, message = "Max word limit must be between 1 and your input number")
    private final Integer maxWordLimit;

    @NotNull(message = "Attachments is required")
    private final Integer attachments;

    @NotNull(message = "Attachments required is required")
    private final Integer attachmentsRequired;

    @NotNull(message = "Grader info is required")
    private final String graderInfo;

    @NotNull(message = "Grader info format is required")
    private final String graderInfoFormat;

    @NotNull(message = "Response template is required")
    private final String responseTemplate;

    @NotNull(message = "Max bytes is required")
    private final Integer maxBytes;

    @NotNull(message = "File types list is required")
    private final String fileTypesList;


    public CreateQtypeEssayQuestionCommand(
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
            String responseFormat,
            Integer responseRequired,
            Integer responseFieldLines,
            Integer minWordLimit,
            Integer maxWordLimit,
            Integer attachments,
            Integer attachmentsRequired,
            String graderInfo,
            String graderInfoFormat,
            String responseTemplate,
            Integer maxBytes,
            String fileTypesList) {
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
        this.responseFormat = responseFormat;
        this.responseRequired = responseRequired;
        this.responseFieldLines = responseFieldLines;
        this.minWordLimit = minWordLimit;
        this.maxWordLimit = maxWordLimit;
        this.attachments = attachments;
        this.attachmentsRequired = attachmentsRequired;
        this.graderInfo = graderInfo;
        this.graderInfoFormat = graderInfoFormat;
        this.responseTemplate = responseTemplate;
        this.maxBytes = maxBytes;
        this.fileTypesList = fileTypesList;
    }
}
