package com.backend.programming.learning.system.auth.service.domain.dto.method.create.user;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserCommand {
    @NotNull
    @Email
    private final String email;

    private final String username;

    private final UUID organizationId;

    @NotNull
    private final String password;

    @NotNull
    private final String firstName;

    @NotNull
    private final String lastName;

    @NotNull
    private final String phone;

    private final String roleName;
}
