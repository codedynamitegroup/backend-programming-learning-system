package com.backend.programming.learning.system.core.service.domain.dto.method.delete.question;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QuestionDeleteResponse {
    @NotNull
    private final UUID questionId;
    @NotNull
    private final UUID qtypeId;

    @NotNull
    private final String message;
}
