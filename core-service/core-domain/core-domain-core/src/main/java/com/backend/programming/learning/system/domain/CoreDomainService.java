package com.backend.programming.learning.system.domain;

import com.backend.programming.learning.system.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.domain.event.CertificateCourseCreatedEvent;

public interface CoreDomainService {
    CertificateCourseCreatedEvent createCertificateCourse(CertificateCourse certificateCourse);
}
