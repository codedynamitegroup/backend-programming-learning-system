package com.backend.programming.learning.system.auth.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateRoleResponse {
    @NotNull
    private UUID id;
    private final String description;
    @NotNull
    private final String name;
    @NotNull
    private final String message;
}
