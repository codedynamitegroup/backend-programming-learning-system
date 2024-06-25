package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.MostEnrolledWithStudentResponse;
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
            UUID filterTopicId
    );

    List<CertificateCourse> findAllCertificateCoursesByIsRegistered(
            String courseName,
            UUID filterTopicId,
            boolean isRegistered,
            UUID userId
    );

    void deleteCertificateCourse(UUID certificateCourseId);
    List<CertificateCourse> findMostEnrolledCertificateCourses();

    List<CertificateCourse> findMostEnrolledCertificateCoursesByTopicIds(List<UUID> topicIds);

    int countNumOfCompletedResources(UUID certificateCourseId, UUID userId);
    int countNumOfResourcesByCertificateId(UUID certificateCourseId);
    int countNumOfStudentsByCertificateId(UUID certificateCourseId);
    int countNumOfReviewsByCertificateId(UUID certificateCourseId);

    List<CertificateCourse> findAllCourse();
    List<MostEnrolledWithStudentResponse> findMostEnrolledCertificateCourseWithStudentCount();

    Page<CertificateCourse> findAllCertificateCourses(Integer page, Integer size, String searchName);
    Page<CertificateCourse> findAllMyCompletedCertificateCourses(Integer page, Integer size, UUID userId);
}
