package com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter;

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
    @NotNull(message = "CertificateCourseId is required")
    private final UUID certificateCourseId;
    @NotNull(message = "Title is required")
    private final String title;
    @NotNull(message = "Description is required")
    private final String description;
    @NotNull(message = "CreatedBy is required")
    private final UUID createdBy;
    @NotNull(message = "UpdatedBy is required")
    private final UUID updatedBy;
}
