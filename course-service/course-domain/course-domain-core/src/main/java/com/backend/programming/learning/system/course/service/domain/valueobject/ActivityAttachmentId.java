package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ActivityAttachmentId extends BaseId<UUID> {
    public ActivityAttachmentId(UUID value) {
        super(value);
    }
}
