package com.backend.programming.learning.system.core.service.domain.dto.method.update.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateQuestionResponse {
    @NotNull
    private final UUID questionId;
    @NotNull
    private final UUID qtypeId;
    @NotNull
    private final String message;
}

