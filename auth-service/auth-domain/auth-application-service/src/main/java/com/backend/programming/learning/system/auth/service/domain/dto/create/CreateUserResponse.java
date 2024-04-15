package com.backend.programming.learning.system.auth.service.domain.dto.create;

import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserResponse {
    @NotNull
    private UUID id;
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
