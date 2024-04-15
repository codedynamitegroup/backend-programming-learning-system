package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class CertificateCourseId extends BaseId<UUID> {
    public CertificateCourseId(UUID value) {
        super(value);
    }
}
