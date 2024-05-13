package com.backend.programming.learning.system.core.service.domain.dto.responseentity.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
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
