package com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse_user;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic.TopicResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class CertificateCourseUserResponseEntity {
    @NotNull
    private final UserResponseEntity user;
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final Boolean isCompleted;
    @NotNull
    private final ZonedDateTime completedAt;
    @NotNull
    private final ZonedDateTime createdAt;
    @NotNull
    private final ZonedDateTime updatedAt;
}
