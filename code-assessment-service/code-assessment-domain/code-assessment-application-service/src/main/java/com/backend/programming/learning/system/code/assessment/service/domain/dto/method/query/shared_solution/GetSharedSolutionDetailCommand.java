package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class GetSharedSolutionDetailCommand {
    @NotNull(message = "sharedSolutionId must not be null")
    @JsonIgnore
    @Setter
    UUID sharedSolutionId;

    @NotNull(message = "userId must not be null")
    UUID userId;

}
