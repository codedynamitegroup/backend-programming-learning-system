package com.backend.programming.learning.system.core.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
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
    private final UUID startTime;
    private final UUID endTime;
    @NotNull
    private final UUID createdBy;
    @NotNull
    private final UUID updatedBy;
}
