package com.backend.programming.learning.system.core.service.domain.dto.method.update.contest;

import com.backend.programming.learning.system.core.service.domain.dto.validator.contest.UpdateContestCommandStartTimeAndEndTimeValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@UpdateContestCommandStartTimeAndEndTimeValidator
public class UpdateContestCommand {
    private final UUID contestId;
    private final String name;
    private final String description;
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;
    @NotNull
    private final UUID updatedBy;
}
