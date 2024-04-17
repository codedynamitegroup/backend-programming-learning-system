package com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteContestResponse {
    @NotNull
    private final UUID contestId;
    @NotNull
    private final String message;
}
