package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteSharedSolutionVoteCommand {
    @NotNull(message = "userId must not be null")
    UUID userId;

    @NotNull(message = "sharedSolutionId must not be null")
    UUID sharedSolutionId;

    public void setUserId(@NotNull(message = "userId must not be null") UUID userId) {
        this.userId = userId;
    }

    public void setSharedSolutionId(@NotNull(message = "sharedSolutionId must not be null") UUID sharedSolutionId) {
        this.sharedSolutionId = sharedSolutionId;
    }
}
