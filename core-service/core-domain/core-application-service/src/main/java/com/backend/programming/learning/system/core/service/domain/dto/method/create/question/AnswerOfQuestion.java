package com.backend.programming.learning.system.core.service.domain.dto.method.create.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class AnswerOfQuestion {
    @NotNull(message = "Feedback is required")
    private String feedback;

    @NotNull(message = "Answer is required")
    private String answer;

    @NotNull(message = "Fraction is required")
    private float fraction;
}
