package com.backend.programming.learning.system.core.service.domain.event;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;

import java.time.ZonedDateTime;

public class ContestCreatedEvent extends ContestEvent {

    public ContestCreatedEvent(Contest contest, ZonedDateTime createdAt) {
        super(contest, createdAt);
    }
}
