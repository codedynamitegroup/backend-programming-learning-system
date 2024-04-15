package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseTopic;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;

public interface CertificateCourseUserRepository {
    CertificateCourseUser saveCertificateCourseUser(CertificateCourseUser certificateCourseUser);
}
