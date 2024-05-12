package com.backend.programming.learning.system.course.service.domain.dto.method.update.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateUserResponse {
    @NotNull
    private UUID userId;

    @NotNull
    private final String message;
}
