package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.vote;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteSharedSolutionVoteCommand {
    @NotNull(message = "userId must not be null")
    UUID userId;

    @NotNull(message = "sharedSolutionId must not be null")
    @JsonIgnore
    @Setter
    UUID sharedSolutionId;

}
