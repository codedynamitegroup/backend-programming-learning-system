package com.backend.programming.learning.system.course.service.domain.dto.responseentity.user;

import com.backend.programming.learning.system.course.service.domain.entity.RoleMoodle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UserResponseEntity {
    @NotNull
    private final UUID userId;

    private final RoleMoodle roleMoodle;
    @NotNull
    private final String fullName;
    @NotNull
    private final String email;
}
