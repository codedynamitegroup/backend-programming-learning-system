package com.backend.programming.learning.system.core.service.domain.dto.responseentity.review;

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
public class ReviewResponseEntity {
    @NotNull
    private final UUID reviewId;
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final String content;
    @NotNull
    private final Float rating;
    @NotNull
    private final UserResponseEntity createdBy;
    @NotNull
    private final UserResponseEntity updatedBy;
    @NotNull
    private final ZonedDateTime createdAt;
    @NotNull
    private final ZonedDateTime updatedAt;
}
