package com.backend.programming.learning.system.core.service.domain.dto.create.contest;

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
    @NotNull
    private final String name;
    @NotNull
    private final String description;
    @NotNull
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;
    @NotNull
    private final UUID createdBy;
    @NotNull
    private final UUID updatedBy;
}
