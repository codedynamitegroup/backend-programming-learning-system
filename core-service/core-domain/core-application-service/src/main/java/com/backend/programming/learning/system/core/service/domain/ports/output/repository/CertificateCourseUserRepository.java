package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface CertificateCourseUserRepository {
    CertificateCourseUser saveCertificateCourseUser(CertificateCourseUser certificateCourseUser);
    Page<CertificateCourseUser> findAllByCertificateCourseId(
            UUID certificateCourseId, Integer pageNo, Integer pageSize, Boolean fetchAll);
}
