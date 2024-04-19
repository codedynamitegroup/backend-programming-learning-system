package com.backend.programming.learning.system.core.service.domain.dto.method.update.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateQtypeEssayQuestionCommand {
    @NotNull
    private final UUID qtEssayQuestionId;

    private final String responseFormat;
    private final Integer responseRequired;
    private final Integer responseFieldLines;
    private final Integer minWordLimit;
    private final Integer maxWordLimit;
    private final Integer attachments;
    private final Integer attachmentsRequired;
    private final String graderInfo;
    private final String graderInfoFormat;
    private final String responseTemplate;
    private final Integer maxBytes;
    private final String fileTypesList;

    @NotNull
    private final UpdateQuestionEntity question;
}
