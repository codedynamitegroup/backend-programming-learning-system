package com.backend.programming.learning.system.auth.service.domain.dto.method.update.user;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class UpdateUserProfileCommand {
    @NotNull
    @Email
    private final String email;

    private ZonedDateTime dob;

    private String firstName;

    private String lastName;

    private String phone;

    private String address;

    private String avatarUrl;
}
