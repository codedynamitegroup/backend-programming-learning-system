package com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic.TopicResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CertificateCourseResponseEntity {
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final String name;
    @NotNull
    private final String description;
    @NotNull
    private final String skillLevel;
    @NotNull
    private final Float avgRating;
    @NotNull
    private final ZonedDateTime startTime;
    @NotNull
    private final ZonedDateTime endTime;
    @NotNull
    private final TopicResponseEntity topic;
    @NotNull
    private final Boolean isDeleted;
    @NotNull
    private final UserResponseEntity createdBy;
    @NotNull
    private final UserResponseEntity updatedBy;
    @NotNull
    private final ZonedDateTime createdAt;
    @NotNull
    private final ZonedDateTime updatedAt;
}
