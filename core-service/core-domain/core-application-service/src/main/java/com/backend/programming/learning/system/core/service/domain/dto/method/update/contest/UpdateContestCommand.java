package com.backend.programming.learning.system.core.service.domain.dto.method.update.contest;

import com.backend.programming.learning.system.core.service.domain.dto.validator.contest.UpdateContestCommandStartTimeAndEndTimeValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@UpdateContestCommandStartTimeAndEndTimeValidator
public class UpdateContestCommand {
    private final UUID contestId;
    private final String name;
    private final String description;
    private final String thumbnailUrl;
    private final String prizes;
    private final String rules;
    private final String scoring;
    private final Boolean isPublic;
    private final Boolean isRestrictedForum;
    private final Boolean isDisabledForum;
    private final List<UUID> questionIds;
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;
    private final String email;
}
