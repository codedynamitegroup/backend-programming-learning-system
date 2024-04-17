package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCourseUsersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCourseUsersResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse_user.CertificateCourseUserDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class CertificateCourseUserCommandHandler {
    private final CertificateCourseUserCreateHelper certificateCourseUserCreateHelper;
    private final CertificateCourseUserQueryHelper certificateCourseUserQueryHelper;
    private final CertificateCourseUserDataMapper certificateCourseUserDataMapper;

    public CertificateCourseUserCommandHandler(CertificateCourseUserCreateHelper certificateCourseUserCreateHelper,
                                               CertificateCourseUserQueryHelper certificateCourseUserQueryHelper,
                                               CertificateCourseUserDataMapper certificateCourseUserDataMapper) {
        this.certificateCourseUserCreateHelper = certificateCourseUserCreateHelper;
        this.certificateCourseUserQueryHelper = certificateCourseUserQueryHelper;
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

    @Transactional(readOnly = true)
    public QueryAllCertificateCourseUsersResponse findAllCertificateCourseUsers(
            QueryAllCertificateCourseUsersCommand queryAllCertificateCourseUsersCommand) {
        Page<CertificateCourseUser> certificateCourseUsers = certificateCourseUserQueryHelper
                .queryAllCertificateCourseUsers(
                        queryAllCertificateCourseUsersCommand.getCertificateCourseId(),
                        queryAllCertificateCourseUsersCommand.getPageNo(),
                        queryAllCertificateCourseUsersCommand.getPageSize(),
                        queryAllCertificateCourseUsersCommand.getFetchAll());

        return certificateCourseUserDataMapper
                .certificateCourseUsersToQueryAllCertificateCourseUsersResponse(
                        certificateCourseUsers);
    }
}
