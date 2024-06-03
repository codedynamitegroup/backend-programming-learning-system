package com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_question.ContestQuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class ContestResponseEntity {
    private final UUID contestId;
    private final String name;
    private final String description;
    private final String prizes;
    private final String rules;
    private final String scoring;
    private final String thumbnailUrl;
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;
    private final Integer numOfParticipants;
    private final Boolean isRegistered;
    private final List<ContestQuestionResponseEntity> questions;
    private final Boolean isPublic;
    private final Boolean isRestrictedForum;
    private final Boolean isDisabledForum;
    private final UserResponseEntity createdBy;
    private final UserResponseEntity updatedBy;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
}
