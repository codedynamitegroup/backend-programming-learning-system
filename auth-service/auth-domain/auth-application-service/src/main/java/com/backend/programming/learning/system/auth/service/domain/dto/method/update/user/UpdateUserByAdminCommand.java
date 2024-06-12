package com.backend.programming.learning.system.auth.service.domain.dto.method.update.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class UpdateUserByAdminCommand {
    @NotNull
    private final String email;

    private ZonedDateTime dob;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String phone;

    private String address;

    private String roleName;
}
