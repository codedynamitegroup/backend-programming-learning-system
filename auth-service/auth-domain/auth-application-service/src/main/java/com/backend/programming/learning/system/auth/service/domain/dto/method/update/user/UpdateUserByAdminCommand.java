package com.backend.programming.learning.system.auth.service.domain.dto.method.update.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateUserByAdminCommand {
    private final UUID userId;

    private ZonedDateTime dob;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String phone;

    private String address;

    @NotNull
    private String roleName;

    private String avatarUrl;

    private Boolean isDeleted;
}
