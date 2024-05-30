package com.backend.programming.learning.system.core.service.domain.dto.method.create.question;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.*;
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

    @Min(value = -1, message = "Min word limit must be between 1 and 1000 and equal -1 if unlimited")
    private final Integer minWordLimit;

    @Min(value = -1, message = "Max word limit must be between 1 and 1000")
    private final Integer maxWordLimit;

    @NotNull(message = "Attachments is required")
    private final Integer attachments;

    private final Integer attachmentsRequired;
    private final String graderInfo;
    private final String graderInfoFormat;
    private final String responseTemplate;
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
            String generalFeedback,
            @NotNull(message = "Default mark is required") @DecimalMin(value = "0.0", message = "Default mark must be greater than or equal 0")
            @Digits(integer = 5, fraction = 2, message = "Default mark must have up to 5 digits and 2 decimals") BigDecimal defaultMark,
            @NotNull(message = "Question type is required") String qType,
            @NotNull(message = "Answers is required") List<AnswerOfQuestion> answers,
            UUID questionBankCategoryId,
            Boolean isOrgQuestionBank,
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
                answers,
                questionBankCategoryId,
                isOrgQuestionBank);
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
