package com.backend.programming.learning.system.auth.service.domain.dto.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserResponse {
    @NotNull
    @Email
    private final String email;

    private final String firstName;

    private final String lastName;

    private final String phone;

    @NotNull
    private final ZonedDateTime createdAt;

    @NotNull
    private final String message;
}
