package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class DeleteSharedSolutionCommand {
    @NotNull(message = "email must not be null")
    String email;

    @NotNull(message = "sharedSolutionId must not be null")
    @JsonIgnore
    @Setter
    UUID sharedSolutionId;
}
