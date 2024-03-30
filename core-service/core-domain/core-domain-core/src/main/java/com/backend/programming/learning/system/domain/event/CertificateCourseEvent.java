package com.backend.programming.learning.system.domain.event;

import com.backend.programming.learning.system.domain.entity.CertificateCourse;

import java.time.ZonedDateTime;

public abstract class CertificateCourseEvent implements DomainEvent<CertificateCourse> {
    private final CertificateCourse certificateCourse;
    private final ZonedDateTime createdAt;

    public CertificateCourseEvent(CertificateCourse certificateCourse, ZonedDateTime createdAt) {
        this.certificateCourse = certificateCourse;
        this.createdAt = createdAt;
    }

    public CertificateCourse getCertificateCourse() {
        return certificateCourse;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
