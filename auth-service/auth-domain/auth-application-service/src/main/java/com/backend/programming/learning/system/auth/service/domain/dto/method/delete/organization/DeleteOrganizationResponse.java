package com.backend.programming.learning.system.auth.service.domain.dto.method.delete.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteOrganizationResponse {
    @NotNull
    private final UUID organizationId;

    @NotNull
    private final String message;
}
