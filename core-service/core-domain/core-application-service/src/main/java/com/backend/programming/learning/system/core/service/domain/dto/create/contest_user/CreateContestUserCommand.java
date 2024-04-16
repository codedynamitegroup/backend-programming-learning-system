package com.backend.programming.learning.system.core.service.domain.dto.create.contest_user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateContestUserCommand {
    @NotNull
    private final UUID userId;
    @NotNull
    private final UUID contestId;

}
