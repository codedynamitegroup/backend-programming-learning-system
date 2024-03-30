package com.backend.programming.learning.system.domain.event;

import com.backend.programming.learning.system.domain.entity.Contest;

import java.time.ZonedDateTime;

public class ContestCreatedEvent extends ContestEvent {

    public ContestCreatedEvent(Contest contest, ZonedDateTime createdAt) {
        super(contest, createdAt);
    }
}
