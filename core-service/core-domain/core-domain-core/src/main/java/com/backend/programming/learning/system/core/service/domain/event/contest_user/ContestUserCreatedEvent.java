package com.backend.programming.learning.system.core.service.domain.event.contest_user;

import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;

import java.time.ZonedDateTime;
import java.util.List;

public class ContestUserCreatedEvent extends ContestUserEvent {
    public ContestUserCreatedEvent(
            ContestUser contestUser, List<String> failureMessages) {
        super(contestUser, failureMessages);
    }

    @Override
    public void fire() {
    }
}
