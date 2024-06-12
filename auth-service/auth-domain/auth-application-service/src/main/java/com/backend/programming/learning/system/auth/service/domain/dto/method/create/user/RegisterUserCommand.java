package com.backend.programming.learning.system.auth.service.domain.dto.method.create.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class RegisterUserCommand {
    @NotNull
    @Email
    private final String email;

    @NotNull
    private final String password;

    @NotNull
    private final String firstName;

    @NotNull
    private final String lastName;
}
