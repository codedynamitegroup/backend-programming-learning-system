package com.backend.programming.learning.system.domain.valueobject;

import java.util.UUID;

public class NotificationId extends BaseId<UUID> {
    public NotificationId(UUID value) {
        super(value);
    }
}
