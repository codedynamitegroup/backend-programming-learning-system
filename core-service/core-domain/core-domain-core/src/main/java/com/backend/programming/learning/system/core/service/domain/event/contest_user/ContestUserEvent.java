package com.backend.programming.learning.system.core.service.domain.event.contest_user;

import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;
import java.util.List;

public abstract class ContestUserEvent implements DomainEvent<ContestUser> {
    private final ContestUser contestUser;
    private final ZonedDateTime createdAt;

    protected ContestUserEvent(ContestUser contestUser, ZonedDateTime createdAt) {
        this.contestUser = contestUser;
        this.createdAt = createdAt;
    }

    public ContestUser getContestUser() {
        return contestUser;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
