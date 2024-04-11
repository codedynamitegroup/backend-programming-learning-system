package com.backend.programming.learning.system.domain.core.service.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;

public interface CoreRepository {
    CertificateCourse saveCertificateCourse(CertificateCourse certificateCourse);
}
