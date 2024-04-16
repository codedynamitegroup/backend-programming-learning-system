package com.backend.programming.learning.system.core.service.domain.dto.create.question;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CreateQtypeEssayQuestionCommand extends CreateQuestionCommand{
    @NotNull
    private final String responseFormat;
    @NotNull
    private final Integer responseRequired;
    @NotNull
    private final Integer responseFieldLines;
    @NotNull
    private final Integer minWordLimit;
    @NotNull
    private final Integer maxWordLimit;
    @NotNull
    private final Integer attachments;
    @NotNull
    private final Integer attachmentsRequired;
    @NotNull
    private final String graderInfo;
    @NotNull
    private final Integer graderInfoFormat;
    @NotNull
    private final String responseTemplate;
    @NotNull
    private final Integer maxBytes;
    @NotNull
    private final String fileTypesList;


    public CreateQtypeEssayQuestionCommand(@NotNull(message = "Organization ID is required") UUID organizationId,
                                           @NotNull(message = "Created by is required") UUID createdBy,
                                           @NotNull(message = "Updated by is required") UUID updatedBy,
                                           @NotNull(message = "Difficulty by is required") String difficulty,
                                           @NotNull(message = "Name is required") String name,
                                           @NotNull(message = "Question text is required") String questionText,
                                           @NotNull(message = "General feedback is required") String generalFeedback,
                                           @NotNull(message = "Default mark is required") BigDecimal defaultMark,
                                           @NotNull(message = "Question type is required") String qType,
                                           String responseFormat,
                                           Integer responseRequired,
                                           Integer responseFieldLines,
                                           Integer minWordLimit,
                                           Integer maxWordLimit,
                                           Integer attachments,
                                           Integer attachmentsRequired,
                                           String graderInfo,
                                           Integer graderInfoFormat,
                                           String responseTemplate,
                                           Integer maxBytes,
                                           String fileTypesList) {
        super(organizationId, createdBy, updatedBy, difficulty, name, questionText, generalFeedback, defaultMark, qType);
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
