package com.backend.programming.learning.system.core.service.domain.dto.create.question;

import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateQuestionResponse {
    @NotNull
    private final QuestionId questionId;
    @NotNull
    private final String message;
}
