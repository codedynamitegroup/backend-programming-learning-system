package com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateContestQuestionCommand {
    @NotNull(message = "QuestionId is required")
    private final UUID questionId;
    @NotNull(message = "ContestId is required")
    private final UUID contestId;
}
