package com.backend.programming.learning.system.dto.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private final String password;

    private final String firstName;

    private final String lastName;

    private final String phone;
}
