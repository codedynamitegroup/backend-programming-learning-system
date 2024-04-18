package com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ContestResponseEntity {
    @NotNull
    private final UUID contestId;
    @NotNull
    private final String name;
    @NotNull
    private final String description;
    @NotNull
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;
    @NotNull
    private final List<QuestionResponseEntity> questions;
    @NotNull
    private final UserResponseEntity createdBy;
    @NotNull
    private final UserResponseEntity updatedBy;
    @NotNull
    private final ZonedDateTime createdAt;
    @NotNull
    private final ZonedDateTime updatedAt;
}
