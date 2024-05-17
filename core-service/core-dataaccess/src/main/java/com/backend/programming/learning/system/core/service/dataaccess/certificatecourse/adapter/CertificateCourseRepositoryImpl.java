package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper.CertificateCourseDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CertificateCourseRepositoryImpl implements CertificateCourseRepository {
    private final CertificateCourseJpaRepository certificateCourseJpaRepository;
    private final CertificateCourseDataAccessMapper certificateCourseDataAccessMapper;

    public CertificateCourseRepositoryImpl(CertificateCourseJpaRepository certificateCourseJpaRepository,
                                           CertificateCourseDataAccessMapper certificateCourseDataAccessMapper) {
        this.certificateCourseJpaRepository = certificateCourseJpaRepository;
        this.certificateCourseDataAccessMapper = certificateCourseDataAccessMapper;
    }

    @Override
    public CertificateCourse saveCertificateCourse(CertificateCourse certificateCourse) {
        return certificateCourseDataAccessMapper.certificateCourseEntityToCertificateCourse(
                certificateCourseJpaRepository.save(certificateCourseDataAccessMapper
                        .certificateCourseToCertificateCourseEntity(certificateCourse)));
    }

    @Override
    public Optional<CertificateCourse> findById(CertificateCourseId certificateCourseId) {
        return certificateCourseJpaRepository.findById(certificateCourseId.getValue())
                .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse);

    }

    @Override
    public Optional<CertificateCourse> findByName(String name) {
        return certificateCourseJpaRepository.findByName(name)
                .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse);
    }

    @Override
    public List<CertificateCourse> findAllCertificateCourses(
            String courseName,
            List<UUID> filterTopicIds
    ) {
        return certificateCourseJpaRepository.findAllByCourseNameAndByFilterTopicIds(
                        courseName,
                        filterTopicIds.isEmpty() ? null : filterTopicIds)
                .stream()
                .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                .toList();
    }

    @Override
    public List<CertificateCourse> findAllCertificateCoursesByIsRegistered(String courseName,
                                                                           List<UUID> filterTopicIds,
                                                                           boolean isRegistered,
                                                                           UUID userId) {
        if (isRegistered) {
            return certificateCourseJpaRepository.findAllByCourseNameAndByFilterTopicIdsAndRegisteredBy(
                            courseName,
                            filterTopicIds.isEmpty() ? null : filterTopicIds,
                            userId)
                    .stream()
                    .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                    .toList();
        } else {
            return certificateCourseJpaRepository.findAllByCourseNameAndByFilterTopicIdsAndNotRegisteredBy(
                            courseName,
                            filterTopicIds.isEmpty() ? null : filterTopicIds,
                            userId)
                    .stream()
                    .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                    .toList();
        }
    }

    @Override
    public void deleteCertificateCourse(UUID certificateCourseId) {
        certificateCourseJpaRepository.deleteById(certificateCourseId);
    }

    @Override
    public List<CertificateCourse> findMostEnrolledCertificateCourses(String courseName,
                                                                      List<UUID> filterTopicIds) {

        return certificateCourseJpaRepository.findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIds(
                                courseName,
                                filterTopicIds.isEmpty() ? null : filterTopicIds)
                        .stream()
                        .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                        .toList();
    }

    @Override
    public List<CertificateCourse> findMostEnrolledCertificateCoursesByIsRegistered(
            String courseName,
            List<UUID> filterTopicIds,
            boolean isRegistered,
            UUID userId) {
        if (isRegistered) {
            return certificateCourseJpaRepository.findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIdsAndRegisteredBy(
                            courseName,
                            filterTopicIds.isEmpty() ? null : filterTopicIds,
                            userId)
                    .stream()
                    .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                    .toList();
        } else {
            return certificateCourseJpaRepository.findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIdsAndNotRegisteredBy(
                            courseName,
                            filterTopicIds.isEmpty() ? null : filterTopicIds,
                            userId)
                    .stream()
                    .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                    .toList();
        }
    }

    @Override
    public int countNumOfCompletedQuestions(UUID certificateCourseId, UUID userId) {
        return certificateCourseJpaRepository.countNumOfCompletedQuestions(certificateCourseId, userId);
    }
}
