package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper.CertificateCourseDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

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
                certificateCourseJpaRepository
                .save(certificateCourseDataAccessMapper
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
    public Page<CertificateCourse> findAll(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        return certificateCourseJpaRepository.findAllByIsDeletedFalse(paging)
                .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse);
    }

    @Override
    public int deleteCertificateCourse(UUID certificateCourseId) {
        return certificateCourseJpaRepository.deleteById(true, certificateCourseId);
    }

    @Override
    public int updateAvgRating(CertificateCourseId certificateCourseId, Float avgRating) {
        return certificateCourseJpaRepository.updateAvgRating(avgRating, certificateCourseId.getValue());
    }
}
