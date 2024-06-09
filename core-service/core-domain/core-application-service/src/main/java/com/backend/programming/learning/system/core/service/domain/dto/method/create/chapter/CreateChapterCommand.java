package com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    private final String email;
}
