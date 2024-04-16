package com.backend.programming.learning.system.core.service.domain.dto.create.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class AnswerOfQuestion {
    @NotNull(message = "Feedback is required")
    private String feedback;

    @NotNull(message = "Answer is required")
    private String answer;

    @NotNull(message = "Fraction is required")
    @Size(min = 0, message = "Fraction must be between 0 and 1")
    private float fraction;
}
