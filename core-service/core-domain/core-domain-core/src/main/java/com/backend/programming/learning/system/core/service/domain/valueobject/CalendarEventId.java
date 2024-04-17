package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class CalendarEventId extends BaseId<UUID> {
    public CalendarEventId(UUID value) {
        super(value);
    }
}
