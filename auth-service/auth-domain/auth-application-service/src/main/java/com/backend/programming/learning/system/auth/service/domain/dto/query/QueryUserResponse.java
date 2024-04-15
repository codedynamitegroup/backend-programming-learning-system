package com.backend.programming.learning.system.auth.service.domain.dto.query;

import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryUserResponse{
    @NotNull
    private UUID id;

    @NotNull
    @Email
    private final String email;

    private ZonedDateTime dob;

    private final String firstName;

    private final String lastName;

    private final String phone;

    private String address;
    private String avatarUrl;
    private String refreshToken;
    private String lastIp;
    private ZonedDateTime lastLogin;
    private Boolean isDeleted;

    @NotNull
    private final ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
