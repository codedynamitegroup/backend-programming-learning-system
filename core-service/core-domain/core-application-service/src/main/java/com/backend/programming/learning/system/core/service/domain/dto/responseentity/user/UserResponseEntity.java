package com.backend.programming.learning.system.core.service.domain.dto.responseentity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UserResponseEntity {
    @NotNull
    private final UUID userId;
    @NotNull
    private final String email;

    private String firstName;
    private String lastName;
    private ZonedDateTime dob;
    private String avatarUrl;
    private String phone;
    private String address;
}
