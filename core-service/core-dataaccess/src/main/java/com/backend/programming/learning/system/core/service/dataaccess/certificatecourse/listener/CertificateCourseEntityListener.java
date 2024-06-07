package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.listener;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse.CertificateCourseRedisService;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CertificateCourseEntityListener {
    private final CertificateCourseRedisService certificateCourseRedisService;

    public CertificateCourseEntityListener(CertificateCourseRedisService certificateCourseRedisService) {
        this.certificateCourseRedisService = certificateCourseRedisService;
    }

    @PrePersist
    public void prePersist(CertificateCourseEntity certificateCourseEntity) {
        log.info("PrePersist");
    }

    @PostPersist
    public void postPersist(CertificateCourseEntity certificateCourseEntity) {
        log.info("PostPersist");
        certificateCourseRedisService.clearAllCertificateCourses();
    }

    @PreUpdate
    public void preUpdate(CertificateCourseEntity certificateCourseEntity) {
        log.info("PreUpdate");
    }

    @PostUpdate
    public void postUpdate(CertificateCourseEntity certificateCourseEntity) {
        log.info("PostUpdate");
        certificateCourseRedisService.clearAllCertificateCourses();
    }

    @PreRemove
    public void preRemove(CertificateCourseEntity certificateCourseEntity) {
        log.info("PreRemove");
    }

    @PostRemove
    public void postRemove(CertificateCourseEntity certificateCourseEntity) {
        log.info("PostRemove");
        certificateCourseRedisService.clearAllCertificateCourses();
    }
}
