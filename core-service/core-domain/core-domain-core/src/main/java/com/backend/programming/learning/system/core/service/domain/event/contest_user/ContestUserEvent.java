package com.backend.programming.learning.system.core.service.domain.event.contest_user;

import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;
import java.util.List;

public abstract class ContestUserEvent implements DomainEvent<ContestUser> {
    private final ContestUser contestUser;
    private final List<String> failureMessages;

    protected ContestUserEvent(ContestUser contestUser, List<String> failureMessages) {
        this.contestUser = contestUser;
        this.failureMessages = failureMessages;
    }

    public ContestUser getContestUser() {
        return contestUser;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }
}
