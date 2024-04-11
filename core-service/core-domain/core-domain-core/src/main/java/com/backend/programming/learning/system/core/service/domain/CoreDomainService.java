package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.event.CertificateCourseCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;

public interface CoreDomainService {
    CertificateCourseCreatedEvent createCertificateCourse(CertificateCourse certificateCourse);
}
