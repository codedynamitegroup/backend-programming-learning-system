package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class CertificateCourseUserId extends BaseId<UUID> {
    public CertificateCourseUserId(UUID value) {
        super(value);
    }
}
