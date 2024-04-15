package com.backend.programming.learning.system.auth.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrganizationResponse {
    @NotNull
    private UUID id;

    @NotNull
    @Email
    private String email;

    private String description;

    @NotNull
    private String name;

    private String phone;
    private String address;
    @NotNull
    private final String message;
}
