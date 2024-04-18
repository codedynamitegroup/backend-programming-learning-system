package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.mapper.CertificateCourseUserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.repository.CertificateCourseUserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CertificateCourseUserRepositoryImpl implements CertificateCourseUserRepository {

    private final CertificateCourseUserJpaRepository certificateCourseUserJpaRepository;
    private final CertificateCourseUserDataAccessMapper certificateCourseUserDataAccessMapper;

    public CertificateCourseUserRepositoryImpl(CertificateCourseUserJpaRepository certificateCourseUserJpaRepository,
                                               CertificateCourseUserDataAccessMapper certificateCourseUserDataAccessMapper) {
        this.certificateCourseUserJpaRepository = certificateCourseUserJpaRepository;
        this.certificateCourseUserDataAccessMapper = certificateCourseUserDataAccessMapper;
    }

    @Override
    public CertificateCourseUser saveCertificateCourseUser(CertificateCourseUser certificateCourseUser) {
        return certificateCourseUserDataAccessMapper.
            certificateCourseUserEntityToCertificateCourseUser(
                certificateCourseUserJpaRepository.save(
                        certificateCourseUserDataAccessMapper.
                                certificateCourseUserToCertificateCourseUserEntity(certificateCourseUser)
                )
            );
    }

    @Override
    public Page<CertificateCourseUser> findAllByCertificateCourseId(
            UUID certificateCourseId, Integer pageNo, Integer pageSize, Boolean fetchAll) {
        Pageable paging = fetchAll ? Pageable.unpaged() : PageRequest.of(pageNo, pageSize);
        return certificateCourseUserJpaRepository.findAllByCertificateCourseId(certificateCourseId, paging)
                .map(certificateCourseUserDataAccessMapper::certificateCourseUserEntityToCertificateCourseUser);
    }

    @Override
    public Optional<CertificateCourseUser> findByCertificateCourseIdAndUserId(UUID certificateCourseId, UUID userId) {
        return certificateCourseUserJpaRepository.findByCertificateCourseIdAndUserId(certificateCourseId, userId)
                .map(certificateCourseUserDataAccessMapper::certificateCourseUserEntityToCertificateCourseUser);
    }
}
