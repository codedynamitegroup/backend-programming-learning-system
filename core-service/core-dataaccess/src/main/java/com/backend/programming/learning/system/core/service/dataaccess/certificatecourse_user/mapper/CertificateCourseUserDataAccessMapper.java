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
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseUserId;
import org.springframework.stereotype.Component;

@Component
public class CertificateCourseUserDataAccessMapper {
    private final CertificateCourseDataAccessMapper certificateCourseDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;

    public CertificateCourseUserDataAccessMapper(CertificateCourseDataAccessMapper certificateCourseDataAccessMapper,
                                                 UserDataAccessMapper userDataAccessMapper) {
        this.certificateCourseDataAccessMapper = certificateCourseDataAccessMapper;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public CertificateCourseUserEntity certificateCourseUserToCertificateCourseUserEntity(
            CertificateCourseUser certificateCourseUser) {
        CertificateCourseEntity certificateCourse = certificateCourseDataAccessMapper
                .certificateCourseToCertificateCourseEntity(certificateCourseUser.getCertificateCourse());
        UserEntity user = userDataAccessMapper.userToUserEntity(certificateCourseUser.getUser());

        return CertificateCourseUserEntity.builder()
                .id(certificateCourseUser.getId().getValue())
                .certificateCourse(certificateCourse)
                .user(user)
                .isCompleted(certificateCourseUser.getCompleted())
                .completedAt(certificateCourseUser.getCompletedAt())
                .createdAt(certificateCourseUser.getCreatedAt())
                .updatedAt(certificateCourseUser.getUpdatedAt())
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
                .isCompleted(certificateCourseUserEntity.getIsCompleted())
                .completedAt(certificateCourseUserEntity.getCompletedAt())
                .createdAt(certificateCourseUserEntity.getCreatedAt())
                .updatedAt(certificateCourseUserEntity.getUpdatedAt())
                .build();
    }
}
