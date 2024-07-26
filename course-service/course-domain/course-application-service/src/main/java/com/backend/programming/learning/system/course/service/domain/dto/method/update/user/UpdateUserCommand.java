package com.backend.programming.learning.system.course.service.domain.dto.method.update.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@Data
public class UpdateUserCommand {
    @NotNull
    private final UUID userId;
    private Integer userIdMoodle;
    private String username;

    private ZonedDateTime dob;

    private String firstName;

    private String lastName;

    private String phone;

    private String address;
    private Integer roleMoodleId;

    private String avatarUrl;
}
