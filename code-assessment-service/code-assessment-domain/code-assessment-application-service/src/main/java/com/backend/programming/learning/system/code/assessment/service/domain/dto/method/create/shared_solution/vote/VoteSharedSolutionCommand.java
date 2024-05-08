package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class VoteSharedSolutionCommand {
    @NotNull(message = "userId must not be null")
    UUID userId;

    @NotNull(message = "voteType must not be null")
    Vote voteType;

    @NotNull(message = "sharedSolutionId must not be null")
    UUID sharedSolutionId;

    public void setSharedSolutionId(@NotNull(message = "sharedSolutionId must not be null") UUID sharedSolutionId) {
        this.sharedSolutionId = sharedSolutionId;
    }
}
