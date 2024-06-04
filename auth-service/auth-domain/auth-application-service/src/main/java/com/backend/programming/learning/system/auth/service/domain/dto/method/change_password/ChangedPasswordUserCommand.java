package com.backend.programming.learning.system.auth.service.domain.dto.method.change_password;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class ChangedPasswordUserCommand {
    private final String email;

    @NotNull
    private final String oldPassword;

    @NotNull
    private final String newPassword;
}
