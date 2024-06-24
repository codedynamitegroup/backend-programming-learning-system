package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class UserCodeSubmissionQuery {
    @NotNull(message = "email must not be null")
    String email;

    @Positive(message = "pageSize must be positive")
    Integer pageSize;

    @PositiveOrZero(message = "pageNum must not be negative")
    Integer pageNum;
}
