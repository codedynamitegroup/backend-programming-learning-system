package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.mapper.CertificateCourseUserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.repository.CertificateCourseUserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseUserRepository;
import org.springframework.stereotype.Component;

@Component
public class CertificateCourseUserRepositoryImpl implements CertificateCourseUserRepository {

    private final CertificateCourseUserJpaRepository certificateCourseUserJpaRepository;
    private final CertificateCourseUserDataAccessMapper certificateCourseUserDataAccessMapper;

    public CertificateCourseUserRepositoryImpl(CertificateCourseUserJpaRepository certificateCourseUserJpaRepository, CertificateCourseUserDataAccessMapper certificateCourseUserDataAccessMapper) {
        this.certificateCourseUserJpaRepository = certificateCourseUserJpaRepository;
        this.certificateCourseUserDataAccessMapper = certificateCourseUserDataAccessMapper;
    }

    @Override
    public CertificateCourseUser saveCertificateCourseUser(CertificateCourseUser certificateCourseUser) {
        return certificateCourseUserDataAccessMapper.
            certificateCourseUserEntityToCertificateCourseUser(
                certificateCourseUserJpaRepository.save(
                        certificateCourseUserDataAccessMapper.certificateCourseUserToCertificateCourseUserEntity(certificateCourseUser)
                )
            );
    }
}
