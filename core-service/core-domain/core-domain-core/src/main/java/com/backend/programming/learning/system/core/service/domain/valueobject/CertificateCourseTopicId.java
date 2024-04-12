package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class CertificateCourseTopicId extends BaseId<UUID> {
    public CertificateCourseTopicId(UUID value) {
        super(value);
    }
}
