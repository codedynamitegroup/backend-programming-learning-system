package com.backend.programming.learning.system.core.service.domain.dto.method.delete.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class AnswerOfQuestionDeleteResponse {
    private UUID answerId;
    private final String message;
}
