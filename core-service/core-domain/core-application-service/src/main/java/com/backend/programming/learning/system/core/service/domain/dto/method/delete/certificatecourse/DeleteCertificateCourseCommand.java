package com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteCertificateCourseCommand {
    @NotNull(message = "certificateCourseId is required")
    private final UUID certificateCourseId;
}
