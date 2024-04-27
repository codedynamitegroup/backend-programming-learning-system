package com.backend.programming.learning.system.core.service.domain.event.calendarevent;

import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;

import java.util.List;

public class CalendarEventCreatedEvent extends CalendarEventEvent {
    public CalendarEventCreatedEvent(
            ContestUser contestUser, List<String> failureMessages) {
        super(contestUser, failureMessages);
    }

    @Override
    public void fire() {
    }
}
