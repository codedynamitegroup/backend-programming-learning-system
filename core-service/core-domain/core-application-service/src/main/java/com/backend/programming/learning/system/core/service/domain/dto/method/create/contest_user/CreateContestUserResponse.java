package com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user;

import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestUserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateContestUserResponse {
    @NotNull
    private final UUID contestId;
    @NotNull
    private final UUID userId;
    @NotNull
    private final String message;
}
