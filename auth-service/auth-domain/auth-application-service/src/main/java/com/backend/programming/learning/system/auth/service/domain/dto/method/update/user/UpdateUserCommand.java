package com.backend.programming.learning.system.auth.service.domain.dto.method.update.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateUserCommand {
    @NotNull
    private final String email;

    private ZonedDateTime dob;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String phone;

    private String address;

    private String avatarUrl;
}
