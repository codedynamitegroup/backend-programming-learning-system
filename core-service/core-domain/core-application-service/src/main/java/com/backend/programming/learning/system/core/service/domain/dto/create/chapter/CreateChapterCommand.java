package com.backend.programming.learning.system.core.service.domain.dto.create.chapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateChapterCommand {
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final String title;
    @NotNull
    private final String description;
    @NotNull
    private final UUID createdBy;
    @NotNull
    private final UUID updatedBy;
}
