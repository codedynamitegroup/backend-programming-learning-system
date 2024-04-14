package com.backend.programming.learning.system.core.service.domain.dto.create.contest_user;

import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateContestUserResponse {
    @NotNull
    private final ContestUser contestUser;
    @NotNull
    private final String message;
}
