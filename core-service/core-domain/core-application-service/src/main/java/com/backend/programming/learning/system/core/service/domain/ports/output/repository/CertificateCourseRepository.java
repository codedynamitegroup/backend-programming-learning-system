package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CertificateCourseRepository {
    CertificateCourse saveCertificateCourse(CertificateCourse certificateCourse);
    Optional<CertificateCourse> findById(CertificateCourseId certificateCourseId);
    Optional<CertificateCourse> findByName(String name);
    Page<CertificateCourse> findAll(Integer page, Integer size);
    int deleteCertificateCourse(UUID certificateCourseId);
    int updateAvgRating(CertificateCourseId certificateCourseId, Float avgRating);

    int updateCertificateCourse(CertificateCourse certificateCourse);
}
