package com.backend.programming.learning.system.core.service.domain.dto.create;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.ContestQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateContestQuestionResponse {
    @NotNull
    private final ContestQuestion contestQuestion;
    @NotNull
    private final String message;
}
