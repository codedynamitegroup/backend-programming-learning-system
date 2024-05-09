package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class DeleteSharedSolutionCommad {
    @NotNull(message = "userId must not be null")
    UUID userId;

    @NotNull(message = "sharedSolutionId must not be null")
    UUID sharedSolutionId;

    public void setSharedSolutionId(@NotNull(message = "sharedSolutionId must not be null") UUID sharedSolutionId) {
        this.sharedSolutionId = sharedSolutionId;
    }
}
