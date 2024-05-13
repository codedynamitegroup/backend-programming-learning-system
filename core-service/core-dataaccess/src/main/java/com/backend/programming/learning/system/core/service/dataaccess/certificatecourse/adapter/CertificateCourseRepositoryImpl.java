package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper.CertificateCourseDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.IsRegisteredFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CertificateCourseRepositoryImpl implements CertificateCourseRepository {
    private static final Logger log = LoggerFactory.getLogger(CertificateCourseRepositoryImpl.class);
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
            List<UUID> filterTopicIds,
            IsRegisteredFilter isRegisteredFilter,
            UUID registeredBy
    ) {
        switch (isRegisteredFilter) {
            case REGISTERED:
                return certificateCourseJpaRepository.findAllByCourseNameAndByFilterTopicIdsAndRegisteredBy(
                                courseName,
                                filterTopicIds.isEmpty() ? null : filterTopicIds,
                                registeredBy)
                        .stream()
                        .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                        .toList();
            case NOT_REGISTERED:
                return certificateCourseJpaRepository.findAllByCourseNameAndByFilterTopicIdsAndNotRegisteredBy(
                        courseName,
                                filterTopicIds.isEmpty() ? null : filterTopicIds,
                        registeredBy)
                        .stream()
                        .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                        .toList();
            default:
                return certificateCourseJpaRepository.findAllByCourseNameAndByFilterTopicIds(
                        courseName,
                                filterTopicIds.isEmpty() ? null : filterTopicIds)
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
                                                                      List<UUID> filterTopicIds,
                                                                      IsRegisteredFilter isRegisteredFilter,
                                                                      UUID registeredBy) {
        switch (isRegisteredFilter) {
            case REGISTERED:
                return certificateCourseJpaRepository.findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIdsAndRegisteredBy(
                                courseName,
                                filterTopicIds.isEmpty() ? null : filterTopicIds,
                                registeredBy)
                        .stream()
                        .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                        .toList();
            case NOT_REGISTERED:
                return certificateCourseJpaRepository.findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIdsAndNotRegisteredBy(
                                courseName,
                                filterTopicIds.isEmpty() ? null : filterTopicIds,
                                registeredBy)
                        .stream()
                        .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                        .toList();
            default:
                return certificateCourseJpaRepository.findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIds(
                                courseName,
                                filterTopicIds.isEmpty() ? null : filterTopicIds)
                        .stream()
                        .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                        .toList();
        }


    }
}
