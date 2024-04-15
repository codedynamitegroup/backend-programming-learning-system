package com.backend.programming.learning.system.core.service.domain.event;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;

public abstract class ContestEvent implements DomainEvent<Contest> {
    private final Contest contest;
    private final ZonedDateTime createdAt;

    public ContestEvent(Contest contest, ZonedDateTime createdAt) {
        this.contest = contest;
        this.createdAt = createdAt;
    }

    public Contest getContest() {
        return contest;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
