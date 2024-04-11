package com.backend.programming.learning.system.domain.ports.output.repository;

import com.backend.programming.learning.system.domain.entity.CertificateCourse;

public interface CoreRepository {
    CertificateCourse saveCertificateCourse(CertificateCourse certificateCourse);
}
