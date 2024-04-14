package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper.CertificateCourseDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.entity.CertificateCourseUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse_user.CertificateCourseUserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseUserId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class CertificateCourseUserDataAccessMapper {

    private final CertificateCourseJpaRepository certificateCourseJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final CertificateCourseDataAccessMapper certificateCourseDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;

    public CertificateCourseUserDataAccessMapper(CertificateCourseJpaRepository certificateCourseJpaRepository,
                                                 UserJpaRepository userJpaRepository,
                                                 CertificateCourseDataAccessMapper certificateCourseDataAccessMapper,
                                                 UserDataAccessMapper userDataAccessMapper) {
        this.certificateCourseJpaRepository = certificateCourseJpaRepository;
        this.userJpaRepository = userJpaRepository;
        this.certificateCourseDataAccessMapper = certificateCourseDataAccessMapper;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public CertificateCourseUserEntity certificateCourseUserToCertificateCourseUserEntity(
            CertificateCourseUser certificateCourseUser) {
        CertificateCourseEntity certificateCourse = certificateCourseJpaRepository
                .findById(certificateCourseUser.getCertificateCourse().getId().getValue())
                .orElseThrow(() -> new CertificateCourseNotFoundException("Certificate course with id: " +
                        certificateCourseUser.getCertificateCourse().getId().getValue() + " could not be found!")
                );
        UserEntity user = userJpaRepository
                .findById(certificateCourseUser.getUser().getId().getValue())
                .orElseThrow(() -> new UserNotFoundException("User with id: " +
                        certificateCourseUser.getUser().getId().getValue() + " could not be found!")
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
        CertificateCourse certificateCourse = certificateCourseDataAccessMapper
                .certificateCourseEntityToCertificateCourse(certificateCourseUserEntity.getCertificateCourse());
        User user = userDataAccessMapper.userEntityToUser(certificateCourseUserEntity.getUser());
        return CertificateCourseUser.builder()
                .id(new CertificateCourseUserId(certificateCourseUserEntity.getId()))
                .certificateCourse(certificateCourse)
                .user(user)
                .startTime(certificateCourseUserEntity.getStartTime())
                .isCompleted(certificateCourseUserEntity.getIsCompleted())
                .completedAt(certificateCourseUserEntity.getCompletedAt())
                .build();
    }
}
