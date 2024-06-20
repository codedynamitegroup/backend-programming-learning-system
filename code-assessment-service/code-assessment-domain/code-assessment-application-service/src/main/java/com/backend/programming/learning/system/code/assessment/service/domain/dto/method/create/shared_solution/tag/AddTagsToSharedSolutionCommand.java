package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.tag;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class AddTagsToSharedSolutionCommand {
    @NotNull(message = "email must not be null")
    String email;

    @NotNull(message = "sharedSolutionId must not be null")
    UUID sharedSolutionId;

    @NotNull(message = "tagIds must not be null")
    List<UUID> tagIds;
}
