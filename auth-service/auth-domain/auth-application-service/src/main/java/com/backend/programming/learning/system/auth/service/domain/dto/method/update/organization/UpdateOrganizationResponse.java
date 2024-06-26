package com.backend.programming.learning.system.auth.service.domain.dto.method.update.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateOrganizationResponse {
    @NotNull
    private UUID organizationId;

    @NotNull
    private final String message;
}
