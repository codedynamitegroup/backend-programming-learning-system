package com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_question;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.ContestQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateContestQuestionResponse {
    @NotNull
    private final UUID contestId;
    @NotNull
    private final UUID questionId;
    @NotNull
    private final String message;
}
