package com.backend.programming.learning.system.core.service.domain.dto.method.create.question;

import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateQuestionResponse {
    @NotNull
    private final UUID questionId;

    private final UUID qtypeId;
    @NotNull
    private final String message;
}
