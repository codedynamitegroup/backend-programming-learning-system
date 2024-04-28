package com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user;

import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ContestUserUpdateEventPayload {
    private ContestUser contestUser;
}
