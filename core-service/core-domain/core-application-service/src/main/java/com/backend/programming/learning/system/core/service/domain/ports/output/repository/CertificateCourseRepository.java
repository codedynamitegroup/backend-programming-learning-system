package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;

public interface CertificateCourseRepository {
    CertificateCourse saveCertificateCourse(CertificateCourse certificateCourse);
}
