package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.entity.CertificateCourseUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class CertificateCourseUserDataAccessMapper {

    private final CertificateCourseJpaRepository certificateCourseJpaRepository;
    private final UserJpaRepository userJpaRepository;

    public CertificateCourseUserDataAccessMapper(CertificateCourseJpaRepository certificateCourseJpaRepository,
                                                 UserJpaRepository userJpaRepository) {
        this.certificateCourseJpaRepository = certificateCourseJpaRepository;
        this.userJpaRepository = userJpaRepository;
    }

    public CertificateCourseUserEntity certificateCourseUserToCertificateCourseUserEntity(
            CertificateCourseUser certificateCourseUser) {
        CertificateCourseEntity certificateCourse = certificateCourseJpaRepository
                .findById(certificateCourseUser.getCertificateCourseId().getValue())
                .orElseThrow(() -> new CertificateCourseNotFoundException("Certificate course with id: " +
                        certificateCourseUser.getCertificateCourseId().getValue() + " could not be found!")
                );
        UserEntity user = userJpaRepository
                .findById(certificateCourseUser.getUserId().getValue())
                .orElseThrow(() -> new UserNotFoundException("User with id: " +
                        certificateCourseUser.getUserId().getValue() + " could not be found!")
                );

        return CertificateCourseUserEntity.builder()
                .id(certificateCourseUser.getId().getValue())
                .certificateCourse(certificateCourse)
                .user(user)
                .startTime(certificateCourseUser.getStartTime())
                .isCompleted(certificateCourseUser.getCompleted())
                .completedAt(certificateCourseUser.getCompletedAt())
                .build();
    }

    public CertificateCourseUser certificateCourseUserEntityToCertificateCourseUser(
            CertificateCourseUserEntity certificateCourseUserEntity) {
        return CertificateCourseUser.builder()
                .certificateCourseId(new CertificateCourseId(certificateCourseUserEntity.getCertificateCourse().getId()))
                .userId(new UserId(certificateCourseUserEntity.getUser().getId()))
                .startTime(certificateCourseUserEntity.getStartTime())
                .isCompleted(certificateCourseUserEntity.getIsCompleted())
                .completedAt(certificateCourseUserEntity.getCompletedAt())
                .build();
    }
}
