package com.backend.programming.learning.system.core.service.domain.event.contest;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;

import java.time.ZonedDateTime;

public class ContestEndTimeEvent extends ContestEvent {
    public ContestEndTimeEvent(Contest contest, ZonedDateTime createdAt) {
        super(contest, createdAt);
    }

    @Override
    public void fire() {

    }
}
