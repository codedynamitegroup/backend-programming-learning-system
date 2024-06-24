package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserRecentCodeQuestionQuery {
    @NotNull(message = "email must not be null")
    String email;

    @Positive(message = "pageSize must be positive")
    Integer pageSize;

    @PositiveOrZero(message = "pageNum must not be negative")
    Integer pageNum;
}
