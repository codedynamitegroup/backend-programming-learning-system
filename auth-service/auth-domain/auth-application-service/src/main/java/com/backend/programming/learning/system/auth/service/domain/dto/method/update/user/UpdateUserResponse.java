package com.backend.programming.learning.system.auth.service.domain.dto.method.update.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateUserResponse {
    @NotNull
    private UUID id;
    @NotNull
    @Email
    private final String email;

    @NotNull
    private final String message;
}
