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
public class CreateOrganizationCommand {
    @NotNull
    @Email
    private final String email;

    private final String description;

    @NotNull
    private final String name;

    @NotNull
    private final String phone;

    @NotNull
    private final String address;

    private final String createdBy;
}
