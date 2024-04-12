package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseProgrammingLanguage;

public interface CertificateCourseProgrammingLanguageRepository {
    CertificateCourseProgrammingLanguage saveCertificateCourseProgrammingLanguage(
            CertificateCourseProgrammingLanguage certificateCourseProgrammingLanguage);
}
