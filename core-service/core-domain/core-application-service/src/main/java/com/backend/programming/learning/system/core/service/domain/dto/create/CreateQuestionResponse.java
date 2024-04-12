package com.backend.programming.learning.system.core.service.domain.dto.create;

import com.backend.programming.learning.system.domain.valueobject.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateQuestionResponse {
    @NotNull
    private final QuestionId questionId;
    @NotNull
    private final String message;
}
