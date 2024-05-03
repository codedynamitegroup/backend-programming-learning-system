package com.backend.programming.learning.system.core.service.domain.outbox.model.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class QuestionEventQtypeEssay {
    private String id;
    private String questionId;
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
}
