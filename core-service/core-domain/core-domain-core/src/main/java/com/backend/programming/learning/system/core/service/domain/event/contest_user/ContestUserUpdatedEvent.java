package com.backend.programming.learning.system.core.service.domain.event.contest_user;

import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;

import java.util.List;

public class ContestUserUpdatedEvent extends ContestUserEvent {
    public ContestUserUpdatedEvent(
            ContestUser contestUser, List<String> failureMessages) {
        super(contestUser, failureMessages);
    }

    @Override
    public void fire() {
    }
}
