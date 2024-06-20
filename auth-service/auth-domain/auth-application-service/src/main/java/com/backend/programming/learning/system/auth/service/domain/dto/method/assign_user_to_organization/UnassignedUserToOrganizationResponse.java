package com.backend.programming.learning.system.auth.service.domain.dto.method.assign_user_to_organization;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UnassignedUserToOrganizationResponse {
    @NotNull
    private UUID userId;

    @NotNull
    private final String message;
}
