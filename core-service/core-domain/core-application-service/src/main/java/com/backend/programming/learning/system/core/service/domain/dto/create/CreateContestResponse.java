package com.backend.programming.learning.system.core.service.domain.dto.create;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateContestResponse {
    @NotNull
    private final Contest contest;
    @NotNull
    private final String message;
}
