package com.backend.programming.learning.system.auth.service.domain.dto.delete;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class DeleteUserRoleResponse {
    @NotNull
    private final String message;
}
