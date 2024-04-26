package com.backend.programming.learning.system.core.service.domain.event.contest_user;

import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;

import java.time.ZonedDateTime;
import java.util.List;

public class ContestUserCalendarEventCreateEvent extends ContestUserEvent {
    public ContestUserCalendarEventCreateEvent(
            ContestUser contestUser, ZonedDateTime createdAt, List<String> failureMessages) {
        super(contestUser, createdAt, failureMessages);
    }

    @Override
    public void fire() {
    }
}
