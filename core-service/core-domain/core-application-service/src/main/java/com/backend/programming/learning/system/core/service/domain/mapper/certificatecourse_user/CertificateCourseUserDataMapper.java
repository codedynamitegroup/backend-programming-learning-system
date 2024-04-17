package com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCourseUsersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseUserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CertificateCourseUserDataMapper {
    private final UserDataMapper userDataMapper;

    public CertificateCourseUserDataMapper(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }
    public CertificateCourseUser createCertificateCourseUserCommandToCertificateCourseUser(
            CreateCertificateCourseUserCommand createCertificateCourseUserCommand) {
        return CertificateCourseUser.builder()
                .certificateCourse(CertificateCourse.builder()
                        .id(new CertificateCourseId(createCertificateCourseUserCommand.getCertificateCourseId()))
                        .build())
                .user(User.builder()
                        .id(new UserId(createCertificateCourseUserCommand.getUserId()))
                        .build())
                .isCompleted(false)
                .build();
    }

    public CreateCertificateCourseUserResponse certificateCourseUserToCreateCertificateCourseUserResponse(
            CertificateCourseUser certificateCourseUser, String message) {
        return CreateCertificateCourseUserResponse.builder()
                .certificateCourseId(certificateCourseUser.getCertificateCourse().getId().getValue())
                .userId(certificateCourseUser.getUser().getId().getValue())
                .message(message)
                .build();
    }

    public CertificateCourseUserResponseEntity certificateCourseUserToCertificateCourseUserResponseEntity(
            CertificateCourseUser certificateCourseUser) {
        return CertificateCourseUserResponseEntity.builder()
                .certificateCourseId(certificateCourseUser.getCertificateCourse().getId().getValue())
                .user(userDataMapper.userToUserResponseEntity(certificateCourseUser.getUser()))
                .isCompleted(certificateCourseUser.getCompleted())
                .completedAt(certificateCourseUser.getCompletedAt())
                .createdAt(certificateCourseUser.getCreatedAt())
                .updatedAt(certificateCourseUser.getUpdatedAt())
                .build();
    }

    public QueryAllCertificateCourseUsersResponse certificateCourseUsersToQueryAllCertificateCourseUsersResponse(
            Page<CertificateCourseUser> certificateCourseUsers) {
        List<CertificateCourseUserResponseEntity> certificateCourseUserResponseEntities = new ArrayList<>();
        for (CertificateCourseUser certificateCourseUser : certificateCourseUsers) {
            certificateCourseUserResponseEntities.add(
                    certificateCourseUserToCertificateCourseUserResponseEntity(certificateCourseUser));
        }
        return QueryAllCertificateCourseUsersResponse.builder()
                .certificateCourseUsers(certificateCourseUserResponseEntities)
                .currentPage(certificateCourseUsers.getNumber())
                .totalPages(certificateCourseUsers.getTotalPages())
                .totalItems(certificateCourseUsers.getTotalElements())
                .build();
    }
}
