package com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ContestUserResponseEntity {
    @NotNull
    private final UserResponseEntity user;
    @NotNull
    private final UUID contestId;
    private final UUID calendarEventId;
    @NotNull
    private final Boolean isCompleted;
    @NotNull
    private final ZonedDateTime completedAt;
    @NotNull
    private final ZonedDateTime createdAt;
    @NotNull
    private final ZonedDateTime updatedAt;
}
