package com.backend.programming.learning.system.course.service.domain.dto.method.create.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserCommand {
    @NotNull
    @Email
    private final String email;
    private Integer userIdMoodle;
    private String username;

    @NotNull
    private final String password;

    private final String firstName;

    private final String lastName;

    private final String phone;
}
