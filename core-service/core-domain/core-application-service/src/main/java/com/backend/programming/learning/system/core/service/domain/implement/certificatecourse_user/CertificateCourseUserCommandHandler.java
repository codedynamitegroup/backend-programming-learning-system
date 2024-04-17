package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse_user.CertificateCourseUserDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class CertificateCourseUserCommandHandler {
    private final CertificateCourseUserCreateHelper certificateCourseUserCreateHelper;
    private final CertificateCourseUserDataMapper certificateCourseUserDataMapper;

    public CertificateCourseUserCommandHandler(CertificateCourseUserCreateHelper certificateCourseUserCreateHelper,
                                               CertificateCourseUserDataMapper certificateCourseUserDataMapper) {
        this.certificateCourseUserCreateHelper = certificateCourseUserCreateHelper;
        this.certificateCourseUserDataMapper = certificateCourseUserDataMapper;
    }

    @Transactional
    public CreateCertificateCourseUserResponse createCertificateCourseUser(
            CreateCertificateCourseUserCommand createCertificateCourseUserCommand) {
        CertificateCourseUser certificateCourseUser = certificateCourseUserCreateHelper
                .persistCertificateCourseUser(createCertificateCourseUserCommand);

        log.info("Certificate course user created with id: {}", certificateCourseUser.getId().getValue());

        return certificateCourseUserDataMapper.certificateCourseUserToCreateCertificateCourseUserResponse(
                certificateCourseUser,
                "Certificate course user created successfully");
    }
}
