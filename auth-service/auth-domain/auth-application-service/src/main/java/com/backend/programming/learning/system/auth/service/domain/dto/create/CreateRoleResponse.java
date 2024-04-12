package com.backend.programming.learning.system.auth.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateRoleResponse {
    private final String description;
    @NotNull
    private final String name;
    @NotNull
    private final String message;
}
