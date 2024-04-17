package com.backend.programming.learning.system.core.service.domain.dto.method.create.contest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateContestCommand {
    @NotNull(message = "Name is required")
    private final String name;
    @NotNull(message = "Description is required")
    private final String description;
    @NotNull(message = "Start time is required")
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;
    @NotNull(message = "CreatedBy is required")
    private final UUID createdBy;
    @NotNull(message = "UpdatedBy is required")
    private final UUID updatedBy;
}
