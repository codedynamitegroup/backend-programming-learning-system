package com.backend.programming.learning.system.core.service.domain.event.calendarevent;

import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.util.List;

public abstract class CalendarEventEvent implements DomainEvent<ContestUser> {
    private final ContestUser contestUser;
    private final List<String> failureMessages;

    protected CalendarEventEvent(ContestUser contestUser, List<String> failureMessages) {
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
