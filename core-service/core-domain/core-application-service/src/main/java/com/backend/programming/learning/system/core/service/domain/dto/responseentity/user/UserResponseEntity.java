package com.backend.programming.learning.system.core.service.domain.dto.responseentity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UserResponseEntity {
    @NotNull
    private final UUID userId;
    @NotNull
    private final String email;
}
