package com.backend.programming.learning.system.core.service.domain.outbox.model.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class QuestionEventQtypeCode {
    private String id;
    private String questionId;
    private String dslTemplate;
}
