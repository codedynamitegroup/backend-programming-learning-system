package com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateCertificateCourseResponse {
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final String message;
}
