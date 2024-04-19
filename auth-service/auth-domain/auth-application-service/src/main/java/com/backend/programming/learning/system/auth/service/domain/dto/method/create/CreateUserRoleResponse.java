package com.backend.programming.learning.system.auth.service.domain.dto.method.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserRoleResponse {
    @NotNull
    private UUID id;
    @NotNull
    private String name;

    @NotNull
    private final String message;
}
