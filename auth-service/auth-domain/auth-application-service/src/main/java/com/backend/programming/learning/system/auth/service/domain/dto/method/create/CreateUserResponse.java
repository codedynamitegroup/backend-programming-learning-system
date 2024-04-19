package com.backend.programming.learning.system.auth.service.domain.dto.method.create;

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

    @NotNull
    private final String message;
}
