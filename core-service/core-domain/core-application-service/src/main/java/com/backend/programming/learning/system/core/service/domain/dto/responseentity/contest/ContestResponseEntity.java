package com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_question.ContestQuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
@NoArgsConstructor(force = true)
public class ContestResponseEntity {
    @JsonProperty("contestId")
    private final UUID contestId;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("description")
    private final String description;
    @JsonProperty("prizes")
    private final String prizes;
    @JsonProperty("rules")
    private final String rules;
    @JsonProperty("scoring")
    private final String scoring;
    @JsonProperty("thumbnailUrl")
    private final String thumbnailUrl;
    @JsonProperty("startTime")
    private final ZonedDateTime startTime;
    @JsonProperty("endTime")
    private final ZonedDateTime endTime;
    @JsonProperty("numOfParticipants")
    private final Integer numOfParticipants;
    @JsonProperty("isRegistered")
    private final Boolean isRegistered;
    @JsonProperty("questions")
    private final List<ContestQuestionResponseEntity> questions;
    @JsonProperty("isPublic")
    private final Boolean isPublic;
    @JsonProperty("isRestrictedForum")
    private final Boolean isRestrictedForum;
    @JsonProperty("isDisabledForum")
    private final Boolean isDisabledForum;
    @JsonProperty("createdBy")
    private final UserResponseEntity createdBy;
    @JsonProperty("updatedBy")
    private final UserResponseEntity updatedBy;
    @JsonProperty("createdAt")
    private final ZonedDateTime createdAt;
    @JsonProperty("updatedAt")
    private final ZonedDateTime updatedAt;
}
