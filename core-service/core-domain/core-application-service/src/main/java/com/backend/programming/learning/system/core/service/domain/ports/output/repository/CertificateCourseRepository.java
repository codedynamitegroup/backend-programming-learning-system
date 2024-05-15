package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.IsRegisteredFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CertificateCourseRepository {
    CertificateCourse saveCertificateCourse(CertificateCourse certificateCourse);
    Optional<CertificateCourse> findById(CertificateCourseId certificateCourseId);
    Optional<CertificateCourse> findByName(String name);

    List<CertificateCourse> findAllCertificateCourses(
            String courseName,
            List<UUID> filterTopicIds
    );

    List<CertificateCourse> findAllCertificateCoursesByIsRegistered(
            String courseName,
            List<UUID> filterTopicIds,
            boolean isRegistered,
            UUID userId
    );

    void deleteCertificateCourse(UUID certificateCourseId);
    List<CertificateCourse> findMostEnrolledCertificateCourses(String courseName,
                                                               List<UUID> filterTopicIds);
    List<CertificateCourse> findMostEnrolledCertificateCoursesByIsRegistered(String courseName,
                                                                            List<UUID> filterTopicIds,
                                                                            boolean isRegistered,
                                                                            UUID userId);
}
