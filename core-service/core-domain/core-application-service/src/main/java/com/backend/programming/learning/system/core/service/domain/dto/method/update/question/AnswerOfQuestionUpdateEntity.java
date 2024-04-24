package com.backend.programming.learning.system.core.service.domain.dto.method.update.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class AnswerOfQuestionUpdateEntity {
    @NotNull(message = "Answer ID is required")
    private final UUID answerId;

    private final String feedback;
    private final String answer;
    private final float fraction;
}
