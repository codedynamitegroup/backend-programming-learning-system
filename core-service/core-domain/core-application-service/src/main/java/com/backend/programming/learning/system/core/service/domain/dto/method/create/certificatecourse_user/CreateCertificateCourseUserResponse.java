package com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCertificateCourseUserResponse {
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final UUID userId;
    @NotNull
    private final String message;
}
