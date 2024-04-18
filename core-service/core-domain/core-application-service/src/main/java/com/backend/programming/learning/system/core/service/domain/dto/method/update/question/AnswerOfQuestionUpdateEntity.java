package com.backend.programming.learning.system.core.service.domain.dto.method.update.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class AnswerOfQuestionUpdateEntity {
    private final UUID answerId;
    private final UUID questionId;
    private final String feedback;
    private final String answer;
    private final float fraction;
}
