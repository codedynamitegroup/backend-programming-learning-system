package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;

import java.util.Optional;

public interface CertificateCourseRepository {
    CertificateCourse saveCertificateCourse(CertificateCourse certificateCourse);
    Optional<CertificateCourse> findById(CertificateCourseId certificateCourseId);
    Optional<CertificateCourse> findByName(String name);
}
