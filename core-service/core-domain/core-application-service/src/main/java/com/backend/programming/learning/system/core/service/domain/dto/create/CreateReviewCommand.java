package com.backend.programming.learning.system.core.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateReviewCommand {
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final Float rating;
    @NotNull
    private final String content;
    @NotNull
    private final UUID createdBy;
    @NotNull
    private final UUID updatedBy;
}
