package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseTopic;

public interface CertificateCourseTopicRepository {
    CertificateCourseTopic saveCertificateCourseTopic(
            CertificateCourseTopic certificateCourseTopic);
}
