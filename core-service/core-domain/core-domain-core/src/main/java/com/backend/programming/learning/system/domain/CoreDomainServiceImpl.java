package com.backend.programming.learning.system.domain;

import com.backend.programming.learning.system.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.domain.event.CertificateCourseCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class CoreDomainServiceImpl implements CoreDomainService {
    @Override
    public CertificateCourseCreatedEvent createCertificateCourse(CertificateCourse certificateCourse) {
        return new CertificateCourseCreatedEvent(certificateCourse, ZonedDateTime.now(ZoneId.of("Asis/Ho_Chi_Minh")));
    }
}
