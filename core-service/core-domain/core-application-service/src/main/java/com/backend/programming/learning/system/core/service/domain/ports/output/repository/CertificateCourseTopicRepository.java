package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseTopic;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;

import java.util.Optional;

public interface CertificateCourseTopicRepository {
    CertificateCourseTopic saveCertificateCourseTopic(
            CertificateCourseTopic certificateCourseTopic);
    Optional<CertificateCourseTopic> findByCertificateCourseIdAndTopicId(
            CertificateCourseId certificateCourseId,
            TopicId topicId);
}
