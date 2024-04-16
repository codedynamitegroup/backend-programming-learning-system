package com.backend.programming.learning.system.core.service.domain.dto.create.contest;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateContestResponse {
    @NotNull
    private final UUID contestId;
    @NotNull
    private final String name;
    @NotNull
    private final String message;
}
