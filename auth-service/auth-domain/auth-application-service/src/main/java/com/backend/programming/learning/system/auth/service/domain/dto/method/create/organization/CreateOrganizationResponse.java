package com.backend.programming.learning.system.auth.service.domain.dto.method.create.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrganizationResponse {
    @NotNull
    private UUID organizationId;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String name;

    @NotNull
    private final String message;
}
