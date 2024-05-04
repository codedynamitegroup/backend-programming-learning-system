package com.backend.programming.learning.system.core.service.domain.outbox.model.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class QuestionEventQtypeShortanswer {
    private String id;
    private String questionId;
    private final Boolean caseSensitive;
}
