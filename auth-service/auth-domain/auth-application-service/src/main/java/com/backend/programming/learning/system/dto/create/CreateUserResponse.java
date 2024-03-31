package com.backend.programming.learning.system.dto.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

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
    private final LocalDateTime createdAt;

    @NotNull
    private final String message;
}
