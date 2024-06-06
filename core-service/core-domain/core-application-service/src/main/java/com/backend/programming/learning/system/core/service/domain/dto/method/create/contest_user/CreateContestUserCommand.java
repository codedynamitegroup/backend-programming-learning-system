package com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateContestUserCommand {
    @NotNull(message = "ContestId is required")
    private final UUID contestId;
    private final String email;

}
