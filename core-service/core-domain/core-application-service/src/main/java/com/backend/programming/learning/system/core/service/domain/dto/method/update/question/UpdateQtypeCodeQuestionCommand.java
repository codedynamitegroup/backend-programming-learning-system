package com.backend.programming.learning.system.core.service.domain.dto.method.update.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateQtypeCodeQuestionCommand {
    private final UUID qtCodeQuestionId;
    private final String dslTemplate;
    private final UpdateQuestionUpdateEntity question;
}
