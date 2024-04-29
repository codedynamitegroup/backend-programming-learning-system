package com.backend.programming.learning.system.core.service.domain.event.contest_user;

import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;

import java.time.ZonedDateTime;
import java.util.List;

public class ContestUserUpdatedEvent extends ContestUserEvent {
    public ContestUserUpdatedEvent(
            ContestUser contestUser, ZonedDateTime createdAt) {
        super(contestUser, createdAt);
    }

    @Override
    public void fire() {
    }
}
