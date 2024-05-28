package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class IntroAttachmentId extends BaseId<UUID> {
    public IntroAttachmentId(UUID value) {
        super(value);
    }
}
