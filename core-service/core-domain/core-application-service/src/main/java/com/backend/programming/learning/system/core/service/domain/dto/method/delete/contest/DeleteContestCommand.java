package com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteContestCommand {
    @NotNull(message = "contestId is required")
    private final UUID contestId;
}
