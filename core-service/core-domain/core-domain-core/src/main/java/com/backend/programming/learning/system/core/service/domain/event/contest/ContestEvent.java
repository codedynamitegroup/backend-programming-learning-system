package com.backend.programming.learning.system.core.service.domain.event.contest;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;
import java.util.UUID;

public abstract class ContestEvent implements DomainEvent<Contest> {
    public final Contest contest;
    public final ZonedDateTime createdAt;

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
